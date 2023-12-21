package com.etiya.inventoryservice.business.abstracts;

import com.etiya.inventoryservice.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.inventoryservice.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.inventoryservice.business.dtos.responses.brands.CreateBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.DeleteBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.UpdateBrandResponse;
import com.etiya.inventoryservice.concretes.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest createBrandRequest);

    UpdateBrandResponse update (UpdateBrandRequest updateBrandRequest);

    DeleteBrandResponse delete(int id);

    Optional<Brand> getById(int id);

    List<GetAllBrandResponse> getAll();
}
