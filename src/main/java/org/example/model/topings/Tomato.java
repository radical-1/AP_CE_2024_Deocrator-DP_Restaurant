package org.example.model.topings;

import org.example.model.Food;

public class Tomato extends ToppingDecorator {
    public Tomato(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.2;
    }
}
