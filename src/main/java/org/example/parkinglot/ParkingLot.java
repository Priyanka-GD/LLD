package org.example.parkinglot;

import java.time.Duration;

public class ParkingLot {
    int locationId;
    String locationName;
    private int availableParkingSpots;
    Rate rate;

    public ParkingLot(int spots, Rate rate) {
        this.availableParkingSpots = spots;
        this.rate = rate;
    }

    public int getAvailableParkingSpots() {
        return availableParkingSpots;
    }

    public void decrementAvailableParkingSpots() {
        this.availableParkingSpots--;
    }

    public void incrementAvailableParkingSpots() {
        this.availableParkingSpots++;
    }

    public long getRates(Duration duration) {
        return this.rate.computeRate(duration);
    }

}
