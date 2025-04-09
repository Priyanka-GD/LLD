package org.example.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot instance;
    private int availableSpace;
    private Map<Integer, Vehicle> vehicleList;
    Map<Integer, Ticket> ticketMap;

    public ParkingLot(int availableSpace) {
        this.availableSpace = availableSpace;
        this.vehicleList = new HashMap<>();
        this.ticketMap = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance(int space) {
        if (instance == null) {
            instance = new ParkingLot(space);
        }
        return instance;
    }

    public boolean isParkingAvailable() {
        return this.vehicleList.size() < this.availableSpace;
    }

    public void addVehicle(int ticketId, Vehicle vehicle) {
        if (isParkingAvailable()) {
            this.vehicleList.put(ticketId, vehicle);
            this.ticketMap.put(ticketId, new Ticket(ticketId, vehicle));
        }
    }

    public void removeVehicle(int ticketId) {
        this.vehicleList.remove(ticketId);
        this.ticketMap.remove(ticketId);
    }
}
