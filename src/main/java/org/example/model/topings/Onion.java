package org.example.model.topings;

import org.example.model.Food;

public class Onion extends ToppingDecorator {
    public Onion(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.5;
    }
}
