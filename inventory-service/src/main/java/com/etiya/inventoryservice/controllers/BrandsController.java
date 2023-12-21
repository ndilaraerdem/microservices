package com.etiya.inventoryservice.controllers;

import com.etiya.inventoryservice.business.abstracts.BrandService;
import com.etiya.inventoryservice.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.inventoryservice.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.inventoryservice.business.dtos.responses.brands.CreateBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.DeleteBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @PostMapping
    public CreateBrandResponse add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }
    @GetMapping
    public ResponseEntity<List<GetAllBrandResponse>> getAll(){
        return ResponseEntity.ok(brandService.getAll());
    }
    @PutMapping
    public UpdateBrandResponse add(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        return brandService.update(updateBrandRequest);
    }
    @DeleteMapping
    public DeleteBrandResponse delete(@RequestBody int id){
        return brandService.delete(id);
    }
}
