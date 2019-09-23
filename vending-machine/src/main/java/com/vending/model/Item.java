/*
 * later this model can be extended to sub categories if there are items have extra specifications 
 */
package com.vending.model;

import java.math.BigDecimal;

/**
 * this model used to handle all types of items sold by vending machine
 * each item have properties : name, price, quantity
 * @version 1.0
 */
public class Item {
    private int id;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Item(int id, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
