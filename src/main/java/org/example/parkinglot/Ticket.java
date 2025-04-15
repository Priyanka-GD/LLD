package org.example.parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    int id = 0;
    LocalDateTime entryTime;

    Vehicle vehicle;

    public  Ticket(Vehicle vehichle){
        this.vehicle = vehichle;
        this.entryTime = LocalDateTime.now();
        this.id++;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
