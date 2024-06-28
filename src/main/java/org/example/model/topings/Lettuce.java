package org.example.model.topings;

import org.example.model.Food;

public class Lettuce extends ToppingDecorator {
    public Lettuce(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.8;
    }
}
