package org.example.pizzaorderwithdeal;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements OrderItem {
    PizzaBase pizzaBase;
    List<Topping> toppings;

    public Pizza(PizzaBase pizzaBase) {
        this.toppings = new ArrayList<>();
        this.pizzaBase = pizzaBase;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double basePrice = pizzaBase.getPrice();
        for (Topping topping : this.toppings) {
            basePrice += topping.getPrice();
        }
        return basePrice;
    }
}
