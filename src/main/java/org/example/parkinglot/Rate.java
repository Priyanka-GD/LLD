package org.example.parkinglot;

import java.time.Duration;

public interface Rate {
    long computeRate(Duration duration);
}
