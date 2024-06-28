import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Menu.run();
    }
}
class Menu {
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
                if (!Restaurant.getInstance().isOrderAcceptable(toppings)) {
                    System.out.println("Order Dismissed!");
                    continue;
                }
                Restaurant.getInstance().orderPizza(type, toppings);
            } else if(Regex.SANDWICH_ORDER.isMatch(order)) {
                ArrayList<String> toppings = findToppings(Regex.SANDWICH_ORDER.getGroup(order, "toppings"));
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
enum Regex {
    PIZZA_ORDER("(?<type>Small|Medium|Large) Pizza(?<toppings>.+)"),
    SANDWICH_ORDER("Sandwich(?<toppings>.+)")
    ;
    private final String regex ;

    Regex(String regex) {
        this.regex = regex;
    }

    private Matcher getMather(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        return matcher;
    }

    public boolean isMatch(String input) {
        return getMather(input).matches();
    }

    public boolean isFind(String input) {
        return getMather(input).find();
    }

    public String getGroup(String input, String group) {
        return getMather(input).group(group);
    }
}
interface Food {
    double getPrice();
}
class Pizza implements Food {
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
class Sandwich implements Food {
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
class Restaurant {
    private static Restaurant singleton;
    private HashMap<String, Integer> Inventory = new HashMap<>();
    private ArrayList<Food> orders = new ArrayList<>();

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
        orders.add(order);
    }
    public void orderSandwich(ArrayList<String> toppings) {
        Food order = new Sandwich();
        order = addToppings(order, toppings);
        orders.add(order);
    }
    public Food addToppings(Food order, ArrayList<String> toppings) {
        for (String topping : toppings) {
            if (topping.equals("Pepperoni")) {
                order = new Pepperoni(order);
            } else if (topping.equals("Salami")) {
                order = new Salami(order);
            } else if (topping.equals("Tomato")) {
                order = new Tomato(order);
            } else if (topping.equals("Tuna")) {
                order = new Tuna(order);
            } else if (topping.equals("Pickles")) {
                order = new Pickles(order);
            } else if (topping.equals("Pepper")) {
                order = new Pepper(order);
            } else if (topping.equals("Onion")) {
                order = new Onion(order);
            } else if (topping.equals("Olive")) {
                order = new Olive(order);
            } else if (topping.equals("Mushroom")) {
                order = new Mushroom(order);
            } else if (topping.equals("Lettuce")) {
                order = new Lettuce(order);
            } else if (topping.equals("Jalapeno")) {
                order = new Jalapeno(order);
            } else if (topping.equals("Hamburger")) {
                order = new Hamburger(order);
            } else if (topping.equals("Garlic")) {
                order = new Garlic(order);
            } else if (topping.equals("Fries")) {
                order = new Fries(order);
            } else if (topping.equals("Egg")) {
                order = new Egg(order);
            } else if (topping.equals("Dough")) {
                order = new Dough(order);
            } else if (topping.equals("Corn")) {
                order = new Corn(order);
            } else if (topping.equals("Chicken")) {
                order = new Chicken(order);
            } else if (topping.equals("Cheese")) {
                order = new Cheese(order);
            } else if (topping.equals("Bread")) {
                order = new Bread(order);
            } else if (topping.equals("Basil")) {
                order = new Basil(order);
            } else if (topping.equals("Bacon")) {
                order = new Bacon(order);
            } else if (topping.equals("Sauce")) {
                order = new Sauce(order);
            }
            removeTopping(topping);
        }
        return order;
    }
    public double getTotalPrice() {
        double total = 0;
        for (Food order : orders) {
            total += order.getPrice();
        }
        return total;
    }
    public boolean isOrderAcceptable(ArrayList<String> toppings) {
        HashMap<String, Integer> tempInventory = new HashMap<>(Inventory);
        for (String topping : toppings) {
            if (!tempInventory.containsKey(topping) || tempInventory.get(topping) == 0) {
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
class ToppingDecorator implements Food {
    protected Food tempFood;

    public ToppingDecorator(Food newFood) {
        tempFood = newFood;
    }

    @Override
    public double getPrice() {
        return tempFood.getPrice();
    }
}
class Basil extends ToppingDecorator {
    public Basil(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.2;
    }
}
class Bread extends ToppingDecorator {
    public Bread(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 0.8;
    }
}
class Cheese extends ToppingDecorator {
    public Cheese(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
class Chicken extends ToppingDecorator {
    public Chicken(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.4;
    }
}
class Corn extends ToppingDecorator {
    public Corn(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
class Dough extends ToppingDecorator {
    public Dough(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice();
    }
}
class Egg extends ToppingDecorator {
    public Egg(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.9;
    }
}
class Fries extends ToppingDecorator {
    public Fries(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.6;
    }
}
class Garlic extends ToppingDecorator {
    public Garlic(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.6;
    }
}
class Hamburger extends ToppingDecorator {
    public Hamburger(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.8;
    }
}
class Jalapeno extends ToppingDecorator {
    public Jalapeno(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 4;
    }
}
class Lettuce extends ToppingDecorator {
    public Lettuce(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.8;
    }
}
class Mushroom extends ToppingDecorator {
    public Mushroom(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.6;
    }
}
class Olive extends ToppingDecorator {
    public Olive(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.6;
    }
}
class Onion extends ToppingDecorator {
    public Onion(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.5;
    }
}
class Pepper extends ToppingDecorator {
    public Pepper(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.8;
    }
}
class Pepperoni extends ToppingDecorator {
    public Pepperoni(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3;
    }
}
class Pickles extends ToppingDecorator {
    public Pickles(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() +  2.8;
    }
}
class Salami extends ToppingDecorator {
    public Salami(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1.5;
    }
}
class Sauce extends ToppingDecorator {
    public Sauce(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 1;
    }
}
class Tomato extends ToppingDecorator {
    public Tomato(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 3.2;
    }
}
class Tuna extends ToppingDecorator {
    public Tuna(Food newFood) {
        super(newFood);
    }
    @Override
    public double getPrice() {
        return tempFood.getPrice() + 2.8;
    }
}

