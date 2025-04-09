package org.example.pizzaorderwithdeal;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BuyOneGetOneFreePizzaDeal implements Deal {
    @Override
    public double calculateDiscount(Order order) {
        List<Pizza> pizzas = order.getItems().stream().
                filter(item -> item instanceof Pizza)
                .map(item -> (Pizza) item)
                .sorted(Comparator.comparing(Pizza::getPrice))
                .collect(Collectors.toList());
        int pairs = pizzas.size() / 2;
        double discount = 0.0;
        for (int i = 0; i < pairs; i++) {
            discount += pizzas.get(i * 2).getPrice();
        }
        System.out.println("Discount for BuyOneGetOneFreePizzaDeal : " + discount);
        return discount;
    }
}
