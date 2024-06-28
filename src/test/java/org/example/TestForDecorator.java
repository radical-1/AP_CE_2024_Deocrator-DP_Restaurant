package org.example;

import org.example.model.Restaurant;
import org.example.view.Menu;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.*;


public class TestForDecorator {
    @Before
    public void setUp() {
        Random random = new Random();
        int[] initialRestaurant = new int[23];
        for (int i = 0; i < 23; i++) {
            initialRestaurant[i] = random.nextInt(10);
        }
        Restaurant.initialize(initialRestaurant);
    }
    @Test
    public void testForFoodsWithNoToppings() {
        Restaurant.getInstance().orderPizza("Small", new ArrayList<>());
        Restaurant.getInstance().orderPizza("Medium", new ArrayList<>());
        Restaurant.getInstance().orderPizza("Large", new ArrayList<>());
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Bread", "Bread")));
        Assert.assertEquals(13, Restaurant.getInstance().getTotalPrice(), 0.0);

    }
    @Test
    public void testForOneToppingOnPizza() {
        Restaurant.getInstance().orderPizza("Small", new ArrayList<>(List.of("Pepperoni")));
        Assert.assertEquals(5.0, Restaurant.getInstance().getTotalPrice(), 0.0);
        Restaurant.getInstance().orderPizza("Medium", new ArrayList<>(List.of("Pepperoni")));
        Assert.assertEquals(12.0, Restaurant.getInstance().getTotalPrice(), 0.0);
        Restaurant.getInstance().orderPizza("Large", new ArrayList<>(List.of("Pepperoni")));
        Assert.assertEquals(20.0, Restaurant.getInstance().getTotalPrice(), 0.0);
    }

    @Test
    public void testForTwoToppingsOnPizza() {
        Restaurant.getInstance().orderPizza("Small", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Assert.assertEquals(7.2, Restaurant.getInstance().getTotalPrice(), 0.0);
        Restaurant.getInstance().orderPizza("Medium", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Assert.assertEquals(16.4, Restaurant.getInstance().getTotalPrice(), 0.0);
        Restaurant.getInstance().orderPizza("Large", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Assert.assertEquals(26.6, Restaurant.getInstance().getTotalPrice(), 0.01);
    }
    @Test
    public void orderPizzasAndSandwichesWithDifferentToppings() {
        Restaurant.getInstance().orderPizza("Small", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderPizza("Medium", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderPizza("Large", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Egg", "Fries")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Mushroom", "Fries")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Fries", "Egg")));
        Assert.assertEquals(44, Restaurant.getInstance().getTotalPrice(), 0);
    }
    @Test
    public void testForSomeOrders() {
        Restaurant.getInstance().orderPizza("Small", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderPizza("Medium", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderPizza("Large", new ArrayList<>(List.of("Pepperoni", "Bacon")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Egg", "Fries")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Mushroom", "Fries")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Fries", "Egg")));
        Restaurant.getInstance().orderSandwich(new ArrayList<>(List.of("Fries", "Egg")));
        Assert.assertEquals(49.9, Restaurant.getInstance().getTotalPrice(), 0);
    }

}
