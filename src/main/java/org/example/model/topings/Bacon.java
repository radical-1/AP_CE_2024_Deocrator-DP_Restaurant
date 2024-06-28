package org.example.model.topings;

import org.example.model.Food;

public class Bacon extends ToppingDecorator {
    public Bacon(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.2;
    }

}
