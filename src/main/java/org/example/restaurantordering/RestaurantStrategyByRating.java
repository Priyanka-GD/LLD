package org.example.restaurantordering;

import java.util.Collections;
import java.util.List;

public class RestaurantStrategyByRating implements RestaurantStrategy {
    List<Restaurant> restaurantList;

    public RestaurantStrategyByRating(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        Collections.sort(restaurantList, (rest1, rest2) -> rest2.getRating() - rest1.getRating());
        return restaurantList;
    }
}