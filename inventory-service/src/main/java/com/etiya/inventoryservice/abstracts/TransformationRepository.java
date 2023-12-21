package com.etiya.inventoryservice.abstracts;

import com.etiya.inventoryservice.concretes.Transformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformationRepository extends JpaRepository<Transformation, Integer> {
}
