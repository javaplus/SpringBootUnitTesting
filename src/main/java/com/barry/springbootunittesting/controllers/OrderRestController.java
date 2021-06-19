package com.barry.springbootunittesting.controllers;

import com.barry.springbootunittesting.entities.Pizza;
import com.barry.springbootunittesting.entities.PizzaOrder;
import com.barry.springbootunittesting.entities.PizzaOrderRequest;
import com.barry.springbootunittesting.services.PizzaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private static Logger logger = LoggerFactory.getLogger(OrderRestController.class);

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/price")
    public String calculateCost(@RequestBody Pizza pizza){
        logger.debug(String.format("Pizza Size:{0}", pizza.getSize()));
        logger.debug(String.format("Pizza Toppings: {0}",pizza.getToppings().get(0)));

        double price = pizzaService.calculatePrice(pizza);
        return "Pizza ordered! Total is:$" + price;
    }

    @PostMapping("/order")
    public PizzaOrder orderPizza(@RequestBody PizzaOrderRequest pizzaOrderRequest){
        PizzaOrder pizzaOrder = pizzaService.order(pizzaOrderRequest);
        return pizzaOrder;
    }
    
}