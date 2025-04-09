package org.example.vendingmachine2;

class DispensingState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Dispensing items...");
        machine.setState(new IdleState());
    }

    @Override
    public String getStateName() {
        return "DISPENSING";
    }
}
