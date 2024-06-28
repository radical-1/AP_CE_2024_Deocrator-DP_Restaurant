package org.example.model.topings;

import org.example.model.Food;

public class Tuna extends ToppingDecorator {
    public Tuna(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.8;
    }
}
