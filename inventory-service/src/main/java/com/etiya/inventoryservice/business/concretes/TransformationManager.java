package com.etiya.inventoryservice.business.concretes;

import com.etiya.inventoryservice.abstracts.TransformationRepository;
import com.etiya.inventoryservice.business.abstracts.TransformationService;
import com.etiya.inventoryservice.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.inventoryservice.business.dtos.responses.transformations.CreateTransformationResponse;
import com.etiya.inventoryservice.concretes.Transformation;
import com.etiya.inventoryservice.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransformationManager implements TransformationService {
    TransformationRepository transformationRepository ;
    ModelMapperService modelMapperService;
    @Override
    public CreateTransformationResponse add(CreateTransformationRequest createTransformationRequest) {
        Transformation transformation = modelMapperService.forRequest().map(createTransformationRequest, Transformation.class);

        Transformation createdTransformation = transformationRepository.save(transformation);

        return modelMapperService.forResponse().map(createdTransformation, CreateTransformationResponse.class);
    }
}
