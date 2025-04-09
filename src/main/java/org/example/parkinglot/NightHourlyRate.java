package org.example.parkinglot;

public class NightHourlyRate implements HourlyRate {
    @Override
    public double getPrice() {
        return 6.0;
    }
}
