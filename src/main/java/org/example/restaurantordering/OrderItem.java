package org.example.restaurantordering;

public class OrderItem {
    String itemName;
    double itemPrice;
    String itemDesc;
    int orderId;
    int quantity;

    public OrderItem(String itemName, double itemPrice, String desc, int quantity, int orderId) {
        this.itemName = itemName;
        this.itemDesc = desc;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
    @Override
    public String toString() {
        return itemName + " x" + quantity + " ($" + itemPrice + ")";
    }

}
