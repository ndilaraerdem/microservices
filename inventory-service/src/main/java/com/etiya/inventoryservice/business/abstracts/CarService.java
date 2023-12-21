package com.etiya.inventoryservice.business.abstracts;

import com.etiya.inventoryservice.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.inventoryservice.business.dtos.requests.cars.CreateMaintenanceRequest;
import com.etiya.inventoryservice.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.inventoryservice.business.dtos.responses.cars.*;
import com.etiya.inventoryservice.concretes.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    CreateCarResponse add(CreateCarRequest createCarRequest);

    UpdateCarResponse update (UpdateCarRequest updateCarRequest);

    DeleteCarResponse delete(int id);

    Optional<Car> getById(int id);

    List<GetAllCarsResponse> getAll();

    CreateMaintenanceResponse sendCarToMaintenance (CreateMaintenanceRequest createMaintenanceRequest);

}
