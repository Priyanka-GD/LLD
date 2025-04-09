package org.example.pizzaorderwithdeal;
/*

1. Problem Statement
Design a system that allows a user to calculate the price of a pizza based on its base and toppings.
 The system should be simple, storing all data in memory (no persistent storage required).

A pizza has:
Base: A foundational element, such as a regular or thin crust.
Toppings: Additional ingredients (e.g., cheese, pepperoni, vegetables) that are added on top of the base.
Each base and topping has a specific price.
Prices are store-specific, so different pizza stores will have different prices for the same base or topping.
The system should be able to calculate the price for a full order that includes other items also, like drinks
The system should support various promotional deals like order a pizza and get another for free, or free drink with pizza,
 or most expensive topping for free.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // Configure store
        Store londonStore = new Store("London");
        londonStore.addBasePrice("Thin Crust",5.0);
        londonStore.addToppingPrice("Cheese", 1.0);
        londonStore.addToppingPrice("Pepperoni", 8.0);
        londonStore.addDrinkPrice("Cola", 3.0);

        londonStore.addDeal(new BuyOneGetOneFreePizzaDeal());
        londonStore.addDeal(new FreeDrinkWithPizzaDeal());

        // Create pizzas
        Pizza thinCrustCheesePepperoniPizza = londonStore.buildPizza()
                .withBase("Thin Crust")
                .withTopping("Pepperoni")
                .buildPizza();

        Pizza thinCrustCheesePizza = londonStore.buildPizza()
                .withBase("Thin Crust")
                .withTopping("Cheese")
                .buildPizza();

        // Create Sides
        Drink cola = londonStore.createDrink("Cola");

        // Create order
        Order order = new Order(londonStore);
        order.addItem(thinCrustCheesePepperoniPizza);
        order.addItem(thinCrustCheesePizza);
        order.addItem(cola);

        System.out.println("-------------------------");
        System.out.println("Total Price: " + order.calculateTotal());
    }
}