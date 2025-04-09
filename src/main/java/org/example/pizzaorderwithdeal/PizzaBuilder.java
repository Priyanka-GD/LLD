package org.example.pizzaorderwithdeal;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    Store store;
    List<Topping> toppingList;

    PizzaBase pizzaBase;

    public PizzaBuilder(Store store) {
        this.store = store;
        this.toppingList = new ArrayList<>();
    }

    public PizzaBuilder withBase(String base) throws Exception {
        this.pizzaBase = this.store.createBase(base);
        return this;
    }

    public PizzaBuilder withTopping(String topping) throws Exception {
        this.toppingList.add(this.store.createTopping(topping));
        return this;
    }

    public Pizza buildPizza() {
        if (this.pizzaBase == null)
            throw new IllegalStateException("Need to add a base to Pizza");
        Pizza pizza = new Pizza(this.pizzaBase);
        for (Topping topping : this.toppingList) {
            pizza.addTopping(topping);
        }
        return pizza;
    }

}
