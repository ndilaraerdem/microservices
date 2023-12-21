package com.etiya.inventoryservice.abstracts;

import com.etiya.inventoryservice.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}
