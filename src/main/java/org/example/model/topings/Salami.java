package org.example.model.topings;

import org.example.model.Food;

public class Salami extends ToppingDecorator {
    public Salami(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.5;
    }
}
