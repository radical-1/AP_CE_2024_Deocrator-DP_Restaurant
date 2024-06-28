package org.example.model.topings;

import org.example.model.Food;

public class Corn extends ToppingDecorator {
    public Corn(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
