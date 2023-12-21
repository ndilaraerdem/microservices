package com.etiya.inventoryservice.business.abstracts;

import com.etiya.inventoryservice.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.inventoryservice.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.inventoryservice.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.DeleteColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.UpdateColorResponse;
import com.etiya.inventoryservice.concretes.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    CreateColorResponse add(CreateColorRequest createColorRequest);
    UpdateColorResponse update(UpdateColorRequest updateColorRequest);
    DeleteColorResponse delete(int id);
    List<GetAllColorResponse> getAll();
    Optional<Color> getById(int id);

}
