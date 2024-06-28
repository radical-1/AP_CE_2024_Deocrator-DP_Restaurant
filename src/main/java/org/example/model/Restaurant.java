package org.example.model;

import org.example.model.topings.Pepperoni;
import org.example.model.topings.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private static Restaurant singleton;
    private HashMap<String, Integer> Inventory = new HashMap<>();
    private double profit = 0;

    private Restaurant(int[] numberOfToppings) {
        Inventory.put("Bacon", numberOfToppings[0]);
        Inventory.put("Basil", numberOfToppings[1]);
        Inventory.put("Bread", numberOfToppings[2]);
        Inventory.put("Cheese", numberOfToppings[3]);
        Inventory.put("Chicken", numberOfToppings[4]);
        Inventory.put("Corn", numberOfToppings[5]);
        Inventory.put("Dough", numberOfToppings[6]);
        Inventory.put("Egg", numberOfToppings[7]);
        Inventory.put("Fries", numberOfToppings[8]);
        Inventory.put("Garlic", numberOfToppings[9]);
        Inventory.put("Hamburger", numberOfToppings[10]);
        Inventory.put("Jalapeno", numberOfToppings[11]);
        Inventory.put("Lettuce", numberOfToppings[12]);
        Inventory.put("Mushroom", numberOfToppings[13]);
        Inventory.put("Olive", numberOfToppings[14]);
        Inventory.put("Onion", numberOfToppings[15]);
        Inventory.put("Pepper", numberOfToppings[16]);
        Inventory.put("Pepperoni", numberOfToppings[17]);
        Inventory.put("Pickles", numberOfToppings[18]);
        Inventory.put("Salami", numberOfToppings[19]);
        Inventory.put("Sauce", numberOfToppings[20]);
        Inventory.put("Tomato", numberOfToppings[21]);
        Inventory.put("Tuna", numberOfToppings[22]);
    }
    public static void initialize(int[] numberOfToppings) {
        if (singleton == null) {
            singleton = new Restaurant(numberOfToppings);
        }
    }
    public static Restaurant getInstance() {
        return singleton;
    }

    public void removeTopping(String topping) {

        Inventory.put(topping, Inventory.get(topping) - 1);
    }


    public void orderPizza(String type, ArrayList<String> toppings) {
        Food order;
        if (type.equals("Small")) {
            order = new Pizza(2);
        } else if (type.equals("Medium")) {
            order = new Pizza(4);
        } else {
            order = new Pizza(5);
        }
        order = addToppings(order, toppings);

        profit += order.getPrice();
    }
    public void orderSandwich(ArrayList<String> toppings) {
        Food order = new Sandwich();
        order = addToppings(order, toppings);

        profit += order.getPrice() - 1.6;
    }
    public Food addToppings(Food order, ArrayList<String> toppings) {
        for (String topping : toppings) {
            switch (topping) {
                case "Pepperoni" -> order = new Pepperoni(order);
                case "Salami" -> order = new Salami(order);
                case "Tomato" -> order = new Tomato(order);
                case "Tuna" -> order = new Tuna(order);
                case "Pickles" -> order = new Pickles(order);
                case "Pepper" -> order = new Pepper(order);
                case "Onion" -> order = new Onion(order);
                case "Olive" -> order = new Olive(order);
                case "Mushroom" -> order = new Mushroom(order);
                case "Lettuce" -> order = new Lettuce(order);
                case "Jalapeno" -> order = new Jalapeno(order);
                case "Hamburger" -> order = new Hamburger(order);
                case "Garlic" -> order = new Garlic(order);
                case "Fries" -> order = new Fries(order);
                case "Egg" -> order = new Egg(order);
                case "Dough" -> order = new Dough(order);
                case "Corn" -> order = new Corn(order);
                case "Chicken" -> order = new Chicken(order);
                case "Cheese" -> order = new Cheese(order);
                case "Bread" -> order = new Bread(order);
                case "Basil" -> order = new Basil(order);
                case "Bacon" -> order = new Bacon(order);
                case "Sauce" -> order = new Sauce(order);
            }
            removeTopping(topping);
        }
        return order;
    }
    public double getTotalPrice() {
        return profit;
    }
    public boolean isOrderAcceptable(ArrayList<String> toppings) {
        HashMap<String, Integer> tempInventory = new HashMap<>(Inventory);
        for (String topping : toppings) {
            if (tempInventory.get(topping) == 0) {
                return false;
            }
            tempInventory.put(topping, tempInventory.get(topping) - 1);
        }
        return true;
    }
    public HashMap<String, Integer> getInventory() {
        return Inventory;
    }

}
