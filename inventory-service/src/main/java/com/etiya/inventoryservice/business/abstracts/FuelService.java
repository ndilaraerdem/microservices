package com.etiya.inventoryservice.business.abstracts;

import com.etiya.inventoryservice.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.inventoryservice.business.dtos.responses.fuels.CreateFuelResponse;

public interface FuelService {
    CreateFuelResponse add(CreateFuelRequest createFuelRequest);

}
