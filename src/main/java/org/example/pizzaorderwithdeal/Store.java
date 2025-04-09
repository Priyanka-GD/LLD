package org.example.pizzaorderwithdeal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    String name;
    Map<String, Double> toppingsPrice;
    Map<String, Double> basesPrice;
    Map<String, Double> drinksPrice;
    List<Deal> deals;

    public Store(String name) {
        this.name = name;
        this.toppingsPrice = new HashMap<>();
        this.basesPrice = new HashMap<>();
        this.drinksPrice = new HashMap<>();
        this.deals = new ArrayList<>();
    }

    public void addToppingPrice(String topping, double price) {
        if (!toppingsPrice.containsKey(topping)) {
            toppingsPrice.put(topping, price);
        }
    }

    public void addBasePrice(String base, double price) {
        if (!basesPrice.containsKey(base)) {
            basesPrice.put(base, price);
        }
    }

    public void addDrinkPrice(String drink, double price) {
        if (!drinksPrice.containsKey(drink)) {
            drinksPrice.put(drink, price);
        }
    }

    public PizzaBase createBase(String base) throws Exception {
        if (!basesPrice.containsKey(base)) {
            throw new Exception("No such base exists" + base);
        }
        return new PizzaBase(base, basesPrice.get(base));
    }

    public Topping createTopping(String topping) throws Exception {
        if (!toppingsPrice.containsKey(topping)) {
            throw new Exception("No such topping exists" + topping);
        }
        return new Topping(topping, toppingsPrice.get(topping));
    }

    public Drink createDrink(String drink) throws Exception {
        if (!drinksPrice.containsKey(drink)) {
            throw new Exception("No such drink exists" + drink);
        }
        return new Drink(drink, drinksPrice.get(drink));
    }

    public String getName() {
        return this.name;
    }

    public void addDeal(Deal deal) {
        this.deals.add(deal);
    }

    public List<Deal> getDeals() {
        return this.deals;
    }

    public PizzaBuilder buildPizza() {
        return new PizzaBuilder(this);
    }

}
