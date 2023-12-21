package com.etiya.common.events.inventories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandCreatedEvent {
    private int id;
    private String name;
}
