package org.example.pizzaorderwithdeal;

public class Topping implements OrderItem {
    String name;
    double price;

    public String getName() {
        return name;
    }
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
