package org.example.vendingmachine2;

import java.util.List;

class OrderProcessor {

    public static double getTotal(List<OrderItem> orderItems, VendingMachine machine) {
        machine.handleState();
        double total = 0.0;
        for (OrderItem item : orderItems) {
            String productId = item.getProductId();
            int quantity = item.getQuantity();
            if (!machine.inventory.isAvailable(productId, quantity)) {
                throw new IllegalArgumentException("Product ID " + productId + " is not available in required quantity");
            }

            Product product = machine.inventory.getProductById(productId);
            total += product.getPrice() * quantity;
        }
        return total;
    }

    public static void processOrder(VendingMachine machine, List<OrderItem> orderItems) {
        for (OrderItem item : orderItems) {
            String productId = item.getProductId();
            int quantity = item.getQuantity();

            int remainingQty = machine.inventory.getQuantity(productId) - quantity;
            if (remainingQty == 0) {
                machine.inventory.removeProduct(productId);
            } else {
                machine.inventory.updateQuantity(productId, remainingQty);
            }
        }
        machine.handleState(); // Ready -> Dispensing
        machine.handleState(); // Dispensing -> Idle
    }
}
