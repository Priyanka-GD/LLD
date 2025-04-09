package org.example.vendingmachine2;

interface PaymentStrategy {
    void pay(double amount);

    void collectPayment();
}
