package com.barry.springbootunittesting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.barry.springbootunittesting.entities.Pizza;
import com.barry.springbootunittesting.entities.PizzaOrderRequest;
import com.barry.springbootunittesting.entities.Toppings;

import org.junit.jupiter.api.Test;

public class PizzaServiceTest {


    @Test
    public void calculatePrice_givenZeroToppingsCostIsBasePrice(){
        PizzaService pizzaService = new PizzaService();
        
        
        Pizza pizza = new Pizza();
        List<Toppings> toppingsList = new ArrayList<Toppings>();
        pizza.setToppings(toppingsList);

        double cost = pizzaService.calculatePrice(pizza);

        assertEquals(5.00, cost);

    }
    
}