package org.example.model.topings;

import org.example.model.Food;

public class Chicken extends ToppingDecorator {
    public Chicken(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.4;
    }
}
