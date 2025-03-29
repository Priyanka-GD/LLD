package org.example.parkinglot;

import java.time.LocalTime;

public class Ticket {
    private static int idCounter = 0;
    private final int ticketId;
    private final LocalTime entryTime;

    public Ticket() {
        this.ticketId = ++idCounter; // Assign unique ID
        this.entryTime = LocalTime.now(); // Capture entry time
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

}
