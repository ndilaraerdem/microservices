package com.etiya.filterservice.business.concretes;

import com.etiya.filterservice.business.abstracts.FilterService;
import com.etiya.filterservice.entities.Inventory;
import com.etiya.filterservice.repositories.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterManager implements FilterService {
    FilterRepository filterRepository;
    @Override
    public void add(Inventory inventory) {
        this.filterRepository.save(inventory);
    }
}
