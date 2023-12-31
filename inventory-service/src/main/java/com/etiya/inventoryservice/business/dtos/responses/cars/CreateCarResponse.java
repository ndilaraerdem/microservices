package com.etiya.inventoryservice.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarResponse {
    private int id;
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
    private int brandId;
    private int colorId;
    private String brandName;
    private String colorName;

}
