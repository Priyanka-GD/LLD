package org.example.pizzaorderwithdeal;

import java.util.Comparator;
import java.util.Optional;

public class FreeDrinkWithPizzaDeal implements Deal {
    @Override
    public double calculateDiscount(Order order) {
        boolean hasPizza = order.getItems().stream().anyMatch(item -> item instanceof Pizza);
        if (!hasPizza) {
            return 0.0;
        }

        Optional<Drink> cheapestDrink = order.getItems().stream()
                .filter(item -> item instanceof Drink)
                .map(item -> (Drink) item)
                .min(Comparator.comparing(Drink::getPrice));

        double discount = cheapestDrink.map(Drink::getPrice).orElse(0.0);
        System.out.println("Discount for FreeDrinkWithPizzaDeal : " + discount);
        return discount;
    }
}
