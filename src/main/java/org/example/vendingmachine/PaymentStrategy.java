package org.example.vendingmachine;

interface PaymentStrategy {
    public void pay(double amount);

    public void collectPayment();
}
