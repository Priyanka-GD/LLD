package org.example.parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(10);

        Vehicle car = new Vehicle("Car");
        car.setVehicleNo("KA-01-HH-9999");
        car.setColor("Black");

        int ticketId = 1;
        lot.addVehicle(new Ticket(car), car);

        PaymentStrategy strategy = new PaypalStrategy();
        RateStrategyFactory rateFactory = new RateStrategyFactory();
        ParkingManagement manager = new ParkingManagement(lot, strategy, rateFactory);

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        manager.exitVehicle(ticketId);
        /*
        This code pauses the program for 2 seconds (2000 milliseconds).
        It's often used in test or simulation scenarios to create a time gap —
        in your case, to simulate a vehicle being parked for some time before calculating cost.
         */
    }
}
