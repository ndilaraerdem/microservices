package com.etiya.common.events.inventories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCreatedEvent {
    private int carId;
    private int brandId;
    private String brandName;
    private double dailyPrice;
    private int modelYear;
    private int state;
    private String fuel;
    private String Transformation;
}