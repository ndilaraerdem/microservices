package com.etiya.inventoryservice.business.concretes;

import com.etiya.common.events.inventories.InventoryCreatedEvent;
import com.etiya.inventoryservice.abstracts.CarRepository;
import com.etiya.inventoryservice.business.abstracts.CarService;
import com.etiya.inventoryservice.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.inventoryservice.business.dtos.requests.cars.CreateMaintenanceRequest;
import com.etiya.inventoryservice.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.inventoryservice.business.dtos.responses.cars.*;
import com.etiya.inventoryservice.concretes.Car;
import com.etiya.inventoryservice.kafka.producers.InventoryProducer;
import com.etiya.inventoryservice.utilities.mapping.ModelMapperService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    CarRepository carRepository;
    ModelMapperService modelMapperService;
    InventoryProducer inventoryProducer;

    @Override
    public CreateCarResponse add(CreateCarRequest createCarRequest) {

        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        Car createdCar = carRepository.save(car);

        this.createInventoryCreatedEvent(car);
        return modelMapperService.forResponse().map(createdCar, CreateCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest,Car.class);
        Car updatedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(updatedCar, UpdateCarResponse.class);
    }

    @Override
    public DeleteCarResponse delete(int id) {
        Car carToDelete = new Car();
        carToDelete.setId(id);
        carRepository.delete(carToDelete);
        DeleteCarResponse response = new DeleteCarResponse();
        response.setId(id);
        return response;
    }

    @Override
    public Optional<Car> getById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll(); //veri tabanımızdaki tüm arabaları çekiyoruz.
        return cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    @Transactional
    public CreateMaintenanceResponse sendCarToMaintenance(CreateMaintenanceRequest createMaintenanceRequest) {
       Optional<Car> car = carRepository.findById(createMaintenanceRequest.getCarId());
       car.get().setState(2);

       return modelMapperService.forResponse().map(car, CreateMaintenanceResponse.class);
    }

    private void createInventoryCreatedEvent(Car createdCar) {
        InventoryCreatedEvent inventoryCreatedEvent = new InventoryCreatedEvent();
        inventoryCreatedEvent.setCarId(createdCar.getId());
        inventoryCreatedEvent.setState(createdCar.getState());
        inventoryCreatedEvent.setDailyPrice(createdCar.getDailyPrice());
        inventoryCreatedEvent.setModelYear(createdCar.getModelYear());


        this.inventoryProducer.sendMessage(inventoryCreatedEvent);
    }

}
