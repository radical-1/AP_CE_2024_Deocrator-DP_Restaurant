package org.example.model;

public class Pizza implements Food {
    private double price;

    public Pizza(int price) {
        this.price = price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
