package com.shopify.inventoryapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="INVENTORY_TBL")
public class Inventory {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String category;


}
