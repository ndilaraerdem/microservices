package com.etiya.inventoryservice.kafka.producers;

import com.etiya.common.events.inventories.BrandCreatedEvent;
import com.etiya.common.events.inventories.CarCreatedEvent;
import com.etiya.common.events.inventories.InventoryCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducer {
    public void sendMessage(BrandCreatedEvent event){
    }
    public void sendMessage(CarCreatedEvent event){
    }

    public void sendMessage(InventoryCreatedEvent event){

    }
}
//docker
//kafka
// kafka stack oluşturan bir docker compose oluştur.
//kafka stack oluşturan bir docker compose oluşturur musun
//buna kafka-ui da dahil eder misin
//copilot