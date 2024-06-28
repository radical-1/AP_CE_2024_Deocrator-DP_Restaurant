package org.example.model.topings;

import org.example.model.Food;

public class Olive extends ToppingDecorator {
    public Olive(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.6;
    }
}
