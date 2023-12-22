package com.etiya.filterservice.kafka;

import com.etiya.common.events.inventories.InventoryCreatedEvent;
import com.etiya.filterservice.business.abstracts.FilterService;
import com.etiya.filterservice.entities.Inventory;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryConsumer {
    FilterService filterService;
    @KafkaListener(topics = "inventory-car-created",groupId = "inventory-create")
    public void consume(InventoryCreatedEvent inventoryCreatedEvent){
        Inventory inventory = new Inventory();
        inventory.setBrandName(inventoryCreatedEvent.getBrandName());
        inventory.setBrandId(inventoryCreatedEvent.getBrandId());
        inventory.setCarId(inventoryCreatedEvent.getCarId());
        inventory.setState(inventoryCreatedEvent.getState());
        inventory.setDailyPrice(inventoryCreatedEvent.getDailyPrice());
        inventory.setModelYear(inventoryCreatedEvent.getModelYear());

        this.filterService.add(inventory);
    }
}
