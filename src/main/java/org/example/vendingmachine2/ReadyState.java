package org.example.vendingmachine2;

class ReadyState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Machine is ready to dispense.");
        machine.setState(new DispensingState());
    }

    @Override
    public String getStateName() {
        return "READY";
    }
}
