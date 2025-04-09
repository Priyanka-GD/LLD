package org.example.parkinglot2;

interface PaymentStrategy {
    void pay(double amount);

    void collectPayment();
}
