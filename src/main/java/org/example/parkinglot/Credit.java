package org.example.parkinglot;

public class Credit implements PaymentMode {
    public Credit() {
    }

    @Override
    public void processPayment(long amount) {
        System.out.println("Payment done using Credit card");
    }
}
