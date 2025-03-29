package org.example.parkinglot;

import java.time.Duration;

public class HourlyRate implements Rate {
    int hourlyRate = 5;

    @Override
    public long computeRate(Duration duration) {
        long hours = duration.toHours();
        return hours * hourlyRate;
    }
}
