package com.barry.springbootunittesting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.barry.springbootunittesting.entities.Pizza;
import com.barry.springbootunittesting.entities.PizzaConstants;
import com.barry.springbootunittesting.entities.Toppings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaServiceTest {

    private PizzaService pizzaService;

    @BeforeEach
    public void setup(){
        pizzaService = new PizzaService();
    }

    @Test
    public void calculatePrice_givenZeroToppingsCostIsBasePrice(){
        Pizza pizza = new Pizza();
        List<Toppings> toppingsList = new ArrayList<Toppings>();
        pizza.setToppings(toppingsList);

        double cost = pizzaService.calculatePrice(pizza);

        assertEquals(PizzaConstants.BASE_PRICE, cost);

    }

    @Test
    public void calculatePrice_givenOneToppingCostIsBasePricePlusToppingPrice(){
        
        
        Pizza pizza = new Pizza();
        List<Toppings> toppingsList = new ArrayList<Toppings>();
        toppingsList.add(Toppings.MUSH);
        pizza.setToppings(toppingsList);

        double cost = pizzaService.calculatePrice(pizza);

        assertEquals(PizzaConstants.BASE_PRICE + PizzaConstants.TOPPING_PRICE, cost);

    }

    @Test
    public void calculatePrice_givenTwoToppingCostIsBasePricePlus2TimesToppingPrice(){
        
        
        Pizza pizza = new Pizza();
        List<Toppings> toppingsList = new ArrayList<Toppings>();
        toppingsList.add(Toppings.MUSH);
        toppingsList.add(Toppings.PEP);
        pizza.setToppings(toppingsList);

        double cost = pizzaService.calculatePrice(pizza);

        double expectedCost = PizzaConstants.BASE_PRICE + (2* PizzaConstants.TOPPING_PRICE);

        assertEquals(expectedCost, cost);

    }
    
}