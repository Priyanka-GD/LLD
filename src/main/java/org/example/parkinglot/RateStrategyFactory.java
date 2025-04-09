package org.example.parkinglot;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RateStrategyFactory {
    public static HourlyRate getRate(LocalDateTime entryTime) {
        LocalTime time = entryTime.toLocalTime();

        if (time.isAfter(LocalTime.of(6, 0)) && time.isBefore(LocalTime.of(12, 0))) {
            return new MorningHourlyRate();
        } else if (time.isAfter(LocalTime.of(12, 0)) && time.isBefore(LocalTime.of(18, 0))) {
            return new EveningHourlyRate();
        } else {
            return new NightHourlyRate(); // 6.0
        }
    }
}
