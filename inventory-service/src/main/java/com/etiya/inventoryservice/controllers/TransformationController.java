package com.etiya.inventoryservice.controllers;

import com.etiya.inventoryservice.business.abstracts.TransformationService;
import com.etiya.inventoryservice.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.inventoryservice.business.dtos.responses.transformations.CreateTransformationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transformations")
@AllArgsConstructor
public class TransformationController {
    TransformationService transformationService;
    @PostMapping
    public CreateTransformationResponse add(@RequestBody @Valid CreateTransformationRequest createTransformationRequest){
        return transformationService.add(createTransformationRequest);
    }
}
