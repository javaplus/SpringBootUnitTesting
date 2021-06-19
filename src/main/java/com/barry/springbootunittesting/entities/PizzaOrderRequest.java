package com.barry.springbootunittesting.entities;

import lombok.Data;

@Data
public class PizzaOrderRequest {
    private Pizza pizza;

    private Address address;
    
    
}