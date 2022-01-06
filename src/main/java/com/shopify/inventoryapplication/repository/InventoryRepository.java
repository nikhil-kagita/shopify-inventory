package com.shopify.inventoryapplication.repository;

import com.shopify.inventoryapplication.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findByName(String name);

    List<Inventory> findAllByQuantityLessThanEqual(int quantity);
}
