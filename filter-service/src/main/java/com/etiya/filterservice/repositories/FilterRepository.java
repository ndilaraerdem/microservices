package com.etiya.filterservice.repositories;

import com.etiya.filterservice.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Inventory,Integer> {
}
