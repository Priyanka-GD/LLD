package org.example.restaurantordering;

import java.util.ArrayList;
import java.util.List;

public class RestaurantImp implements Restaurant {
    private final List<OrderItem> orderItemList;
    private final String name;
    private final int rating;

    public RestaurantImp(String name, int rating) {
        this.orderItemList = new ArrayList<>();
        this.name = name;
        this.rating = rating;
    }

    public int getRating() { return rating; }
    public String getName() { return name; }

    @Override
    public void addItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    @Override
    public void removeItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    public List<OrderItem> getOrderItemList() {
        return new ArrayList<>(orderItemList);
    }

    @Override
    public String toString() {
        return name + " (Rating: " + rating + ")";
    }
}