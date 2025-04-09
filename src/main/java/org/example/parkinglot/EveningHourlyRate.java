package org.example.parkinglot;

public class EveningHourlyRate implements HourlyRate {
    @Override
    public double getPrice() {
        return 7.0;
    }
}
