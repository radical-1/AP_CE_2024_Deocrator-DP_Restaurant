package org.example.model.topings;

import org.example.model.Food;

public class Dough extends ToppingDecorator {
    public Dough(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice();
    }
}
