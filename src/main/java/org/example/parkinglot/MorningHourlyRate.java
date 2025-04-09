package org.example.parkinglot;

public class MorningHourlyRate implements HourlyRate {

    @Override
    public double getPrice() {
        return 5.0;
    }
}
