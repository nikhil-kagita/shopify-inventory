package com.shopify.inventoryapplication.controller;

import com.shopify.inventoryapplication.entity.Inventory;
import com.shopify.inventoryapplication.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/inventories/add")
    public Inventory createInventory(@RequestBody Inventory inventory){
        return service.saveInventory(inventory);
    }

    @PostMapping("/inventories/addAll")
    public List<Inventory> createInventories(@RequestBody List<Inventory> inventories){
        return service.saveAllInventories(inventories);
    }

    @PutMapping("/inventories/update")
    public Inventory updateInventory(@RequestBody Inventory inventory){
        return service.updateInventory(inventory);
    }

    @DeleteMapping("inventories/delete/{id}")
    public String deleteInventory(@PathVariable int id){
        return service.deleteInventory(id);
    }

    @GetMapping("/inventories")
    public List<Inventory> getAllInventories(@RequestParam(required = false, name = "maxQuantity") String maxQuantity){
        if(maxQuantity!=null){
            return service.getInventoriesByQuantity(Integer.parseInt(maxQuantity));
        }
        return service.getAllInventories();
    }

    @GetMapping("/inventories/name/{name}")
    public List<Inventory> getInventoriesByName(@PathVariable String name){
        return service.getInventoriesByName(name);
    }

    @GetMapping("/inventories/id/{id}")
    public Inventory getInventoryById(@PathVariable int id){
        return service.getInventoryById(id);
    }
}
