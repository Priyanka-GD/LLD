package org.example.restaurantordering;

import java.util.List;

public interface Restaurant {
    void addItem(OrderItem orderItem);
    void removeItem(OrderItem orderItem);
    int getRating();
    List<OrderItem> getOrderItemList();
    String getName();
}
