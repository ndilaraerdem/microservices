package com.etiya.inventoryservice.business.concretes;

import com.etiya.inventoryservice.abstracts.BrandRepository;
import com.etiya.inventoryservice.business.abstracts.BrandService;
import com.etiya.inventoryservice.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.inventoryservice.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.inventoryservice.business.dtos.responses.brands.CreateBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.DeleteBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.inventoryservice.business.dtos.responses.brands.UpdateBrandResponse;
import com.etiya.inventoryservice.concretes.Brand;
import com.etiya.inventoryservice.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    //business rules
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest){
        //business rules

        Brand brand = modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        Brand createdBrand =  brandRepository.save(brand);

        return modelMapperService.forResponse().map(createdBrand,CreateBrandResponse.class);
    }


    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        Brand updatedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(updatedBrand,UpdateBrandResponse.class);
    }

    @Override
    public DeleteBrandResponse delete(int id) {
        Brand brandToDelete = new Brand();
        brandToDelete.setId(id);
        brandRepository.delete(brandToDelete);
        DeleteBrandResponse response = new DeleteBrandResponse();
        response.setId(id);
        return response;
    }

    @Override
    public Optional<Brand> getById(int id) {
        return brandRepository.findById(id);
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).toList();
    }
}
