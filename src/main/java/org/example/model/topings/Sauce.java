package org.example.model.topings;

import org.example.model.Food;

public class Sauce extends ToppingDecorator {
    public Sauce(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
