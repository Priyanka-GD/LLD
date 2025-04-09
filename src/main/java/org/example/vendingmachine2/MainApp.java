package org.example.vendingmachine2;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        Product coke = new Product("P001", "Coke", 25);
        Product pepsi = new Product("P002", "Pepsi", 30);

        machine.inventory.addProduct(coke, 5);
        machine.inventory.addProduct(pepsi, 3);

        List<OrderItem> order = new ArrayList<>();
        order.add(new OrderItem("P001", 2));
        order.add(new OrderItem("P002", 1));

        try {
            double totalAmount = OrderProcessor.getTotal(order, machine);
            System.out.println("Total Amount: $" + totalAmount);

            PaymentStrategy payment = new PaypalStrategy();
            payment.pay(totalAmount);
            payment.collectPayment();

            OrderProcessor.processOrder(machine, order);
            System.out.println("Machine State after order: " + machine.getCurrentStateName());

        } catch (Exception e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }
}
