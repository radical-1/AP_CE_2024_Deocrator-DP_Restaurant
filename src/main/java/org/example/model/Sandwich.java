package org.example.model;

public class Sandwich implements Food {
    private double price;

    public Sandwich() {
        this.price = 2;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
