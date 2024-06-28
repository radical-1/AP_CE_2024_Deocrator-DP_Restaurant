package org.example.model.topings;

import org.example.model.Food;

public class Jalapeno extends ToppingDecorator {
    public Jalapeno(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 4;
    }
}
