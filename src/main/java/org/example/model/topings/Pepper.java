package org.example.model.topings;

import org.example.model.Food;

public class Pepper extends ToppingDecorator {
    public Pepper(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.8;
    }
}
