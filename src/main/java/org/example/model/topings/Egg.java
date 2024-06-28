package org.example.model.topings;

import org.example.model.Food;

public class Egg extends ToppingDecorator {
    public Egg(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.9;
    }
}
