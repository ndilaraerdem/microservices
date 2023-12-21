package com.etiya.common.events.inventories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCreatedEvent {
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
