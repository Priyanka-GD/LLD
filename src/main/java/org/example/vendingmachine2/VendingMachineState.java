package org.example.vendingmachine2;

interface VendingMachineState {
    void handleRequest(VendingMachine machine);

    String getStateName();
}
