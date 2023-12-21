package com.etiya.inventoryservice.business.abstracts;

import com.etiya.inventoryservice.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.inventoryservice.business.dtos.responses.transformations.CreateTransformationResponse;

public interface TransformationService {
    CreateTransformationResponse add(CreateTransformationRequest createTransformationRequest);

}
