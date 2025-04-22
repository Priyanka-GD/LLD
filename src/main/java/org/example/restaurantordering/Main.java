package org.example.restaurantordering;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderItem orderItem1 = new OrderItem("Lamb Curry", 30.5, "Lamb Curry", 2, 1);
        OrderItem orderItem2 = new OrderItem("Chicken Curry", 20.5, "Chicken Curry", 2, 2);
        OrderItem orderItem3 = new OrderItem("Rice", 10.5, "Rice", 1, 3);

        Restaurant restaurant1 = new RestaurantImp("Shanghai", 5);
        Restaurant restaurant2 = new RestaurantImp("Sonet", 4);
        Restaurant restaurant3 = new RestaurantImp("Victrola", 3);

        List<Restaurant> allRestaurants = new ArrayList<>();
        allRestaurants.add(restaurant3);
        allRestaurants.add(restaurant1);
        allRestaurants.add(restaurant2);

        RestaurantStrategy strategy = new RestaurantStrategyByRating(allRestaurants);
        List<Restaurant> sortedRestaurants = strategy.getRestaurants();

        Restaurant selectedRestaurant = sortedRestaurants.get(0);

        System.out.println("Selected Restaurant: " + ((RestaurantImp) selectedRestaurant).getName());

        Order order = new Order((RestaurantImp) selectedRestaurant);
        order.orderItem(orderItem1);
        order.orderItem(orderItem2);
        order.orderItem(orderItem3);

        order.removeItem(orderItem2);
        System.out.println("Order Summary:");
        selectedRestaurant.getOrderItemList().forEach(System.out::println);
        double total = order.checkOutTotal();
        System.out.println("Total Bill: $" + total);
    }
}
