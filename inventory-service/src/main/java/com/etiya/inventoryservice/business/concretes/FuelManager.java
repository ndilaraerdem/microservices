package com.etiya.inventoryservice.business.concretes;

import com.etiya.inventoryservice.abstracts.FuelRepository;
import com.etiya.inventoryservice.business.abstracts.FuelService;
import com.etiya.inventoryservice.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.inventoryservice.business.dtos.responses.fuels.CreateFuelResponse;
import com.etiya.inventoryservice.concretes.Fuel;
import com.etiya.inventoryservice.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    FuelRepository fuelRepository;
    ModelMapperService modelMapperService;
    @Override
    public CreateFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest, Fuel.class);

        Fuel createdFuel = fuelRepository.save(fuel);

        return modelMapperService.forResponse().map(createdFuel, CreateFuelResponse.class);
    }
}
