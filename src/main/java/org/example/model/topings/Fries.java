package org.example.model.topings;

import org.example.model.Food;

public class Fries extends ToppingDecorator {
    public Fries(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.6;
    }
}
