package org.example.view;

import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] lineOne = input.split("\\s+");
        int[] initialRestaurant = new int[lineOne.length - 1];
        int numberOfOrders = Integer.parseInt(lineOne[0]);
        for (int i = 1; i < lineOne.length; i++) {
            initialRestaurant[i - 1] = Integer.parseInt(lineOne[i]);
        }
        Restaurant.initialize(initialRestaurant);

        for(int i = 0; i < numberOfOrders; i++) {
            String order = scanner.nextLine();
            if(Regex.PIZZA_ORDER.isMatch(order)) {
                String type = Regex.PIZZA_ORDER.getGroup(order, "type");
                ArrayList<String> toppings = findToppings(Regex.PIZZA_ORDER.getGroup(order, "toppings"));
                toppings.add("Dough");
                if (!Restaurant.getInstance().isOrderAcceptable(toppings)) {
                    System.out.println("Order Dismissed!");
                    continue;
                }
                Restaurant.getInstance().orderPizza(type, toppings);
            } else if(Regex.SANDWICH_ORDER.isMatch(order)) {
                ArrayList<String> toppings = findToppings(Regex.SANDWICH_ORDER.getGroup(order, "toppings"));
                toppings.add("Bread");
                toppings.add("Bread");
                if (!Restaurant.getInstance().isOrderAcceptable(toppings)) {
                    System.out.println("Order Dismissed!");
                    continue;
                }
                Restaurant.getInstance().orderSandwich(toppings);
            }
            System.out.println("Order Completed!");
        }
        System.out.printf("The final profit is: %.1f\n", Restaurant.getInstance().getTotalPrice());
    }
    private static ArrayList<String> findToppings(String input) {
        String[] parts = input.split(" ");
        ArrayList<String> toppings = new ArrayList<>();
        for (String part : parts) {
            if (isThisATopping(part)) {
                toppings.add(part);
            }
        }
        return toppings;
    }
    private static boolean isThisATopping(String input) {
        if(input.isEmpty())
            return false;
        if(input.equals("and"))
            return false;
        if(input.equals("with"))
            return false;
        if (input.equals("also"))
            return false;
        if (input.equals("extra"))
            return false;
        return true;
    }
}