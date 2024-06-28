package org.example.model.topings;

import org.example.model.Food;

public class Cheese extends ToppingDecorator {
    public Cheese(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
