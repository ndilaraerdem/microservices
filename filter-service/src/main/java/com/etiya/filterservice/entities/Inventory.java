package com.etiya.filterservice.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "filter-inventory")
public class Inventory {
    @Id
    private int id;
    @Field(name = "carId")
    private int carId;
    @Field(name = "brandId")
    private int brandId;
    @Field(name = "brandName")
    private String brandName;
    @Field(name = "modelYear")
    private int modelYear;
    @Field(name = "state")
    private int state;
    @Field(name = "dailyPrice")
    private double dailyPrice;
}
