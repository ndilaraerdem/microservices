package com.etiya.inventoryservice.business.concretes;

import com.etiya.inventoryservice.abstracts.ColorRepository;
import com.etiya.inventoryservice.business.abstracts.ColorService;
import com.etiya.inventoryservice.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.inventoryservice.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.inventoryservice.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.DeleteColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.inventoryservice.business.dtos.responses.colors.UpdateColorResponse;
import com.etiya.inventoryservice.concretes.Color;
import com.etiya.inventoryservice.utilities.mapping.ModelMapperManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ColorManager implements ColorService {
    ColorRepository colorRepository;
    ModelMapperManager modelMapperService;
    @Override
    public CreateColorResponse add(CreateColorRequest createColorRequest) {
        Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);

        Color createdColor = colorRepository.save(color);

        return modelMapperService.forResponse().map(createdColor, CreateColorResponse.class);    }

    @Override
    public UpdateColorResponse update(UpdateColorRequest updateColorRequest) {
        Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
        Color updatedColor = colorRepository.save(color);
        return modelMapperService.forResponse().map(updatedColor, UpdateColorResponse.class);
    }

    @Override
    public DeleteColorResponse delete(int id) {
        Color colorToDelete = new Color();
        colorToDelete.setId(id);
        colorRepository.delete(colorToDelete);
        DeleteColorResponse response = new DeleteColorResponse();
        response.setId(id);
        return response;
    }

    @Override
    public List<GetAllColorResponse> getAll() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream().map(color-> this.modelMapperService.forResponse()
                .map(color, GetAllColorResponse.class)).toList();
    }

    @Override
    public Optional<Color> getById(int id) {
        return colorRepository.findById(id);
    }

}
