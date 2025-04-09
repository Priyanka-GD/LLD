package org.example.parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    int id;
    LocalDateTime entryTime;

    Vehicle vehicle;

    public  Ticket(int id, Vehicle vehichle){
        this.vehicle = vehichle;
        this.entryTime = LocalDateTime.now();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
