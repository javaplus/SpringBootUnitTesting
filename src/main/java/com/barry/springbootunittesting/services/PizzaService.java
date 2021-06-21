package com.barry.springbootunittesting.services;

import com.barry.springbootunittesting.adapters.ShippingDAO;
import com.barry.springbootunittesting.entities.Pizza;
import com.barry.springbootunittesting.entities.PizzaConstants;
import com.barry.springbootunittesting.entities.PizzaOrder;
import com.barry.springbootunittesting.entities.PizzaOrderRequest;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
   
    public double calculatePrice(Pizza pizza){
        double totalCost = PizzaConstants.BASE_PRICE;
        totalCost+=pizza.getToppings().size() * PizzaConstants.TOPPING_PRICE;
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