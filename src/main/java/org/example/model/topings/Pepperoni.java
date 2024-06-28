package org.example.model.topings;

import org.example.model.Food;

public class Pepperoni extends ToppingDecorator {
    public Pepperoni(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3;
    }
}
