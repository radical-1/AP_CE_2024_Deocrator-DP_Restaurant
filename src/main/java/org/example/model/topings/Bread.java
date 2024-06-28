package org.example.model.topings;

import org.example.model.Food;

public class Bread extends ToppingDecorator {
    public Bread(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 0.8;
    }
}
