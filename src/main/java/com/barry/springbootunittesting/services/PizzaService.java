package com.barry.springbootunittesting.services;

import com.barry.springbootunittesting.adapters.ShippingDAO;
import com.barry.springbootunittesting.entities.Pizza;
import com.barry.springbootunittesting.entities.PizzaOrder;
import com.barry.springbootunittesting.entities.PizzaOrderRequest;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    private static double BASE_PRICE = 5.00;
    private static double TOPPING_PRICE = 2.00;

    public double calculatePrice(Pizza pizza){
        double totalCost = BASE_PRICE;
        totalCost+=pizza.getToppings().size() * TOPPING_PRICE;
        return totalCost;
    }

    public PizzaOrder order(PizzaOrderRequest pizzaOrderRequest) {
        ShippingDAO shippingDAO = new ShippingDAO();

        PizzaOrder pizzaOrder = new PizzaOrder();
        Pizza pizza = pizzaOrderRequest.getPizza();
        pizzaOrder.setPizza(pizza);

        String trackingNumber = shippingDAO.createShippingLabel(pizzaOrderRequest.getAddress());
        pizzaOrder.setTrackingNumber(trackingNumber);

        pizzaOrder.setTotalCost(this.calculatePrice(pizza));
        
        return pizzaOrder;
    }

}