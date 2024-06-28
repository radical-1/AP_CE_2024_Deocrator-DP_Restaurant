package org.example.model.topings;

import org.example.model.Food;

public class ToppingDecorator implements Food {
    protected Food tempFood;

    public ToppingDecorator(Food newFood) {
        tempFood = newFood;
    }

    @Override
    public double getPrice() {
        return tempFood.getPrice();
    }
}
