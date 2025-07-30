import java.util.ArrayList;

/**
 * This is the class for pizza, a type of food item
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public class Pizza extends FoodItem {

    private final ArrayList<String> toppings; // an array list as there could be more than one topping

    /**
     * parameterised constructor
     * @param toppings in the format string
     */
    public Pizza(ArrayList<String> toppings) {

        super();
        this.toppings = toppings;
    }

    /**
     * a method of storing the price of toppings
     * @param topping the string of topping
     * @return the price of topping
     */
    public double toppingPrice(String topping){

        return switch (topping) {
            case "pineapple" -> 2.50;
            case "seafood" -> 3.50;
            default -> 2.00; //ham, cheese, mushroom, tomato
        };
    }

    @Override
    public double calculatePrice() {

        double pizzaPrice = price;
        for (String topping : toppings){ // loop through all the toppings
            pizzaPrice += toppingPrice(topping); // get the price of topping
        }
        return pizzaPrice;
    }

    @Override
    public MealType getMealType() {

        // will check for the specific words in the array list, will be true if it is found
        boolean ham = toppings.contains("ham");
        boolean seafood = toppings.contains("seafood");
        boolean cheese = toppings.contains("cheese");

        if (!ham && !seafood && !cheese){ // having none of them will return vegan
            return MealType.VEGAN;
        } else if (!ham && !seafood) { // if you have cheese but not the other two its vegetarian
            return MealType.VEGETARIAN;
        } else{
            return MealType.MEAT;
        }
    }

    /**
     * toString method
     * @return details of the food
     */
    public String toString() {

        if (toppings.isEmpty()){ // if there are no topping
            return "Pizza without toppings -> " + calculatePrice();
        } else {

            StringBuilder orderDone = new StringBuilder("Pizza with "); // string is immutable

            for (String topping : toppings) {
                orderDone.append(topping.toUpperCase()).append(",");
            }
            orderDone.append(" (").append(getMealType()).append(") topping(s) -> ").append(calculatePrice());
            return orderDone.toString();
        }
    }
}