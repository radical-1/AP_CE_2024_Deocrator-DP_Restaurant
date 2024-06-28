package org.example.model.topings;

import org.example.model.Food;

public class Hamburger extends ToppingDecorator {
    public Hamburger(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.8;
    }
}
