package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/{skuCode}")
    Boolean isInStock(@PathVariable String skuCode){
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(()-> new RuntimeException("Could find the product by sku Code"+ skuCode));
        return inventory.getStock()>0;
    }

    @PostMapping("/Inventory")
    @ResponseStatus(HttpStatus.CREATED)
    public String createInventory(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
        return "created successfully";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> findAll() {
        return (List<Inventory>) inventoryRepository.findAll();
    }



}
