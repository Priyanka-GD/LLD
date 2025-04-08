package org.example.vendingmachine;

import java.util.*;

class VendingMachine {
    private Map<String, FoodItem> inventory;

    public VendingMachine() {
        this.inventory = new HashMap<>();
    }

    public void displayInventory() {
        for (FoodItem item : inventory.values()) {
            System.out.println("Name: " + item.getName() + ", Count: " + item.getCount() + ", Price: $" + item.getPrice());
        }
    }

    public void addFoodItem(FoodItem item) {
        String key = item.getName() + "-" + item.getClass().getSimpleName();
        inventory.put(key, item);
    }

    public double processOrder(List<OrderItem> orderItems) {
        double total = 0.0;

        for (OrderItem orderItem : orderItems) {
            String name = orderItem.getFoodName();
            int quantity = orderItem.getQuantity();

            Optional<String> key = inventory.keySet().stream()
                    .filter(k -> k.startsWith(name + "-"))
                    .findFirst();

            if (key.isEmpty())
                throw new NoSuchElementException("Item " + name + " not found.");

            FoodItem item = inventory.get(key.get());

            if (item.getCount() < quantity)
                throw new IllegalArgumentException("Not enough stock for " + name);

            total += item.getPrice() * quantity;
            item.decrementCount(quantity);

            if (item.getCount() == 0)
                inventory.remove(key.get());
        }

        return total;
    }
}