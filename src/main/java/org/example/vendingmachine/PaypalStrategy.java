package org.example.vendingmachine;

class PaypalStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }

    @Override
    public void collectPayment() {
        // Simulate collection
        System.out.println("Payment collected using PayPal.");
    }
}
