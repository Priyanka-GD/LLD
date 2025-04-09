package org.example.pizzaorderwithdeal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Store store;
    List<OrderItem> orderItems;

    public Order(Store store) {
        this.store = store;
        this.orderItems = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return this.orderItems;
    }

    public void addItem(OrderItem item) {
        this.orderItems.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem orderItem : this.orderItems) {
            total += orderItem.getPrice();
        }
        for (Deal deal : this.store.getDeals()) {
            total -= deal.calculateDiscount(this);
        }
        return total;
    }
}
