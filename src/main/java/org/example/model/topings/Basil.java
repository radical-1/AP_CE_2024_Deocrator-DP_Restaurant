package org.example.model.topings;

import org.example.model.Food;

public class Basil extends ToppingDecorator {
    public Basil(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.2;
    }
}
