package com.example.orderservice.client;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @GetMapping("/api/inventory/{skuCode}")
    Boolean checkStock(@PathVariable String skuCode);
}
