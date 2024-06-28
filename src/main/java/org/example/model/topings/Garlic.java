package org.example.model.topings;

import org.example.model.Food;

public class Garlic extends ToppingDecorator {
    public Garlic(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.6;
    }
}
