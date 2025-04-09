package org.example.parkinglot;

interface PaymentStrategy {
    void pay(double amount);

    void collectPayment();
}
