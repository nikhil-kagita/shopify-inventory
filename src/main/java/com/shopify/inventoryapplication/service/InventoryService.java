package com.shopify.inventoryapplication.service;

import com.shopify.inventoryapplication.entity.Inventory;
import com.shopify.inventoryapplication.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory saveInventory(Inventory inventory){
        return repository.save(inventory);
    }

    public List<Inventory> getAllInventories(){
        return repository.findAll();
    }

    public List<Inventory> getInventoriesByQuantity(int quantity){
        return repository.findAllByQuantityLessThanEqual(quantity);
    }

    public List<Inventory> getInventoriesByName(String name){
        return repository.findByName(name);
    }

    public Inventory getInventoryById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Inventory> saveAllInventories(List<Inventory> inventories){
        return repository.saveAll(inventories);
    }

    public String deleteInventory(int id){
        repository.deleteById(id);
        return "Inventory "+id+" deleted!";
    }

    public Inventory updateInventory(Inventory inventory){
        Inventory existingInventory = repository.findById(inventory.getId()).orElse(null);
        existingInventory.setName(inventory.getName());
        existingInventory.setPrice(inventory.getPrice());
        existingInventory.setQuantity(inventory.getQuantity());
        existingInventory.setCategory(inventory.getCategory());
        return repository.save(existingInventory);
    }
}
