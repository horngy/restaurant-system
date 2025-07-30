/**
 * this interface acts as a blueprint for creating and managing orders
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public interface OrderFormat {

    /**
     * adds a food item into the order
     */
    void addFoodItem();

    /**
     * calculate the total cost of all the foods in an order
     * @return the total cost in the value double
     */
    double totalCost();

    /**
     * retrieve the meal type of the order
     * @return the meal type in the value of MealType
     */
    MealType mealType();

    /**
     * prints out customer details and food items
     */
    void printOrder();

}