package com.etiya.inventoryservice.abstracts;

import com.etiya.inventoryservice.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}
