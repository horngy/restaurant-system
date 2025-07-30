/**
 * This is the class for pasta, a type of food item
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public class Pasta extends FoodItem{

    private final String topping; // in the form of string as only one topping can be chosen

    /**
     * parameterised constructor
     * @param newTopping topping in the format string
     */
    public Pasta(String newTopping){
        super();
        topping = newTopping;
    }

    /**
     * a method to storing the price of topping
     * @param topping the string of topping
     * @return the price of topping in the value double
     */
    public double toppingPrice(String topping){
        return switch (topping) {
            case "tomato" -> 4.00;
            case "marinara" -> 6.80;
            case "none" -> 0.00;
            default -> 5.20; // bolognese, primavera
        };
    }

    @Override
    public double calculatePrice() {
        double pastaPrice = price; // initial price 11.50
        pastaPrice += toppingPrice(topping); // get the price of topping from the method
        return pastaPrice;
    }

    @Override
    public MealType getMealType() {
        return switch (topping) {
            case "tomato", "none" -> MealType.VEGAN;
            case "primavera" -> MealType.VEGETARIAN;
            default -> MealType.MEAT; // bolognese and marinara
        };
    }

    /**
     * the toString method
     * @return details about the food
     */
    public String toString() {
        if (getTopping().equals("none")){
            return "Pasta without toppings -> " + calculatePrice();
        } else {
            return "Pasta with " + getTopping() + "(" + getMealType() + ") topping(s) -> " + calculatePrice();
        }
    }

    /**
     * getter method
     * @return topping
     */
    public String getTopping() {
        return topping;
    }
}