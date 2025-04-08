package org.example.vendingmachine;

public class CreditCardStrategy implements  PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Amount paid through Credit card");
    }

    @Override
    public void collectPayment() {

    }
}
