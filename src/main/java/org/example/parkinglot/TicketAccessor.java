package org.example.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class TicketAccessor {
    Map<Integer, Ticket> tickets;

    public TicketAccessor() {
        this.tickets = new HashMap<>();
    }

    public void updateTicketMap(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }

    public Ticket getTicket(int ticketId) {
        return this.tickets.get(ticketId);
    }
}
