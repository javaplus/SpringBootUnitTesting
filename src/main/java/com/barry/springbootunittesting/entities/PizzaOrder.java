package com.barry.springbootunittesting.entities;

import lombok.Data;

@Data
public class PizzaOrder {
    
    private Pizza pizza;

    private String trackingNumber;
    
    private double totalCost;
    
}