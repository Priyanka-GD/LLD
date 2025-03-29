package org.example.parkinglot;

public class Debit implements PaymentMode {
    public Debit() {

    }

    @Override
    public void processPayment(long amount) {
        System.out.println("Payment done using Debit card");
    }
}
