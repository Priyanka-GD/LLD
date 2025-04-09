package org.example.vendingmachine2;

class VendingMachine {
    Inventory inventory;
    static VendingMachine instance;
    private VendingMachineState currentState;

    public VendingMachine() {
        this.inventory = new Inventory();
        currentState = new IdleState();
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.currentState = vendingMachineState;
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    public void handleState() {
        currentState.handleRequest(this);
    }
}
