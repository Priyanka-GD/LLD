package org.example.vendingmachine2;

class PaypalStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal.");
    }

    @Override
    public void collectPayment() {
        System.out.println("Payment collected using PayPal.");
    }
}
