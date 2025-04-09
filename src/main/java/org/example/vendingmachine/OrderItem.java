package org.example.vendingmachine;

class OrderItem {
    private String foodName;
    private int quantity;

    public OrderItem(String foodName, int quantity) {
        this.foodName = foodName;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }
}