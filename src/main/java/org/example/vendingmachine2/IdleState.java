package org.example.vendingmachine2;

class IdleState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Machine is idle. Waiting for order.");
        machine.setState(new ReadyState());
    }

    @Override
    public String getStateName() {
        return "IDLE";
    }
}
