package com.barry.springbootunittesting.entities;

import java.util.List;

import lombok.Data;

@Data
public class Pizza {

    private Size size;
    private List<Toppings> toppings;


    

}
