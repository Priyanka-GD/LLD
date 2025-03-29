package org.example.parkinglot;

import java.time.Duration;
import java.time.LocalTime;

public class ParkingManager {

    ParkingLot parkingLot;
    TicketAccessor ticketAccessor;

    public ParkingManager(ParkingLot parkingLot, TicketAccessor ticketAccessor) {
        this.parkingLot = parkingLot;
        this.ticketAccessor = ticketAccessor;
    }

    public Ticket vehicleEntry() throws Exception {
        //Permit Entry only when spots available
        if (this.parkingLot.getAvailableParkingSpots() <= 0) {
            throw new Exception("No Parking spots available");
        }
        this.parkingLot.decrementAvailableParkingSpots();
        Ticket newTicket = new Ticket();
        this.ticketAccessor.updateTicketMap(newTicket);
        return newTicket;
    }

    public void vehicleExit(int ticketId, PaymentMode paymentMode) {
        LocalTime exitTime = LocalTime.now();

        Ticket existingTicket = this.ticketAccessor.getTicket(ticketId);
        Duration timeDifference = Duration.between(exitTime, existingTicket.getEntryTime());
        long amount = this.parkingLot.getRates(timeDifference);
        paymentMode.processPayment(amount);

        this.parkingLot.incrementAvailableParkingSpots();
    }


}
