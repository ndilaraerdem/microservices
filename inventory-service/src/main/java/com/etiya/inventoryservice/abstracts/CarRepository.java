package com.etiya.inventoryservice.abstracts;

import com.etiya.inventoryservice.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    int countByBrandId(int brandId);
}
