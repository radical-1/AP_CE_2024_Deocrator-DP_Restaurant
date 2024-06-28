package org.example.model.topings;

import org.example.model.Food;

public class Mushroom extends ToppingDecorator {
    public Mushroom(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.6;
    }
}
