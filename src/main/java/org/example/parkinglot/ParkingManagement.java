package org.example.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingManagement {
    private final ParkingLot parkingLot;
    private final PaymentStrategy paymentStrategy;
    private final RateStrategyFactory rateStrategyFactory;

    public ParkingManagement(ParkingLot parkingLot,
                             PaymentStrategy paymentStrategy,
                             RateStrategyFactory rateStrategyFactory) {
        this.parkingLot = parkingLot;
        this.paymentStrategy = paymentStrategy;
        this.rateStrategyFactory = rateStrategyFactory;
    }

    public double getCost(int ticketId) {
        Ticket ticket = parkingLot.ticketMap.get(ticketId);
        if (ticket == null) return 0.0;

        HourlyRate rate = rateStrategyFactory.getRate(ticket.getEntryTime());
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long hours = duration.toHours();
        if (duration.toMinutes() % 60 != 0) {
            hours++;
        }
        return hours * rate.getPrice();
    }

    public void exitVehicle(int ticketId) {
        Ticket ticket = parkingLot.ticketMap.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID. Cannot process exit.");
            return;
        }

        double cost = getCost(ticketId);
        System.out.println("Total cost for vehicle [" + ticket.vehicle.getVehicleNo() + "]: $" + cost);

        paymentStrategy.collectPayment();
        paymentStrategy.pay(cost);

        parkingLot.removeVehicle(ticketId);
        System.out.println("Vehicle with ticket ID " + ticketId + " has exited.");
    }
}
