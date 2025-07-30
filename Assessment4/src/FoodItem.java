/**
 * An abstract class representing food item in a menu
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public abstract class FoodItem {

    protected double price; // protected so it only can be accessed by itself and inheritor

    /**
     * default constructor, their base price is 11.50
     */
    public FoodItem(){
        price = 11.50;
    }

    /**
     * calculate the price of the food items (including topping(s))
     * @return the price of the food in the value double
     */
    public abstract double calculatePrice();

    /**
     * retrieve the meal type of the food
     * @return the meal type in the value of MealType
     */
    public abstract MealType getMealType();
}