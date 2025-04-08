package org.example.vendingmachine;

import java.util.ArrayList;
import java.util.List;
/*
Use of Interfaces:
FoodItem and PaymentStrategy interfaces are a good abstraction choice.
Promotes extensibility and adheres to Open/Closed Principle.

Strategy Pattern:
PaypalStrategy as a concrete implementation is a good example of the Strategy pattern.

Encapsulation:
Data members are accessed via getter methods — that's clean.

Single Responsibility:
Each class has a clear single purpose (i.e., vending machine logic, food item modeling, order flow, etc.).
*/

public class Order {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addFoodItem(new ChocolateBar("Nestle", 5, 20));
        vendingMachine.addFoodItem(new Chips("Lays", 5, 15));

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Nestle", 2));
        orderItems.add(new OrderItem("Lays", 2));

        try {
            double amount = vendingMachine.processOrder(orderItems);
            System.out.println("Total Amount: $" + amount);

            PaymentStrategy payment = new PaypalStrategy();
            payment.pay(amount);
            payment.collectPayment();

            vendingMachine.displayInventory();

        } catch (Exception e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
}
