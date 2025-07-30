import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the class for orders (implementing the OrderFormat interface)
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public class Order implements OrderFormat {

    private final String customerName;
    private final int customerContactNumber;
    private final String deliveryAddress;
    private final ArrayList<FoodItem> foods = new ArrayList<>(); // an array list as one order can have more than one food item

    /**
     * default constructor
     */
    public Order(){

        customerName = null;
        customerContactNumber = 0;
        deliveryAddress = null;
    }

    /**
     * parameterised constructor
     * @param newCustomerName a string about customer's name
     * @param newCustomerContactNumber an integer about customer's contact number
     * @param newDeliveryAddress a string about customer's delivery address
     */
    public Order(String newCustomerName, int newCustomerContactNumber, String newDeliveryAddress) {

        customerName = newCustomerName;
        customerContactNumber = newCustomerContactNumber;
        deliveryAddress = newDeliveryAddress;
    }

    @Override
    public void addFoodItem() {

        Scanner input = new Scanner(System.in);
        boolean exit = false; // to always run this part until 3 is inputted
        while (!exit) {
            System.out.println("Please select an option");
            System.out.println("===============================");
            System.out.println("1. Add a pizza to the Order");
            System.out.println("2. Add a pasta to the Order");
            System.out.println("3. Back to Main Menu");
            System.out.println("Please enter your choice: (1-3)");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                ArrayList<String> toppings = new ArrayList<>(); // an empty array list to store toppings (can have more than one)
                ArrayList<String> allowedToppings = new ArrayList<>(Arrays.asList("ham", "cheese", "pineapple", "mushrooms", "tomatoes", "seafood"));
                System.out.println("Topping Options:");
                System.out.println("HAM");
                System.out.println("CHEESE");
                System.out.println("PINEAPPLE");
                System.out.println("MUSHROOMS");
                System.out.println("TOMATOES");
                System.out.println("SEAFOOD");
                System.out.println("Enter toppings you want separated by a comma (you can choose more than one or enter blank for no toppings):");
                String choices = input.nextLine();
                String[] topping = choices.split(",");
                for (String x : topping) { // separate user input into single topping
                    if (allowedToppings.contains(x.toLowerCase().trim())){ // make sure the topping is available
                        toppings.add(x.toLowerCase().trim());} // add into the array list if available
                }
                Pizza newPizza = new Pizza(toppings); // create a new pizza with toppings needed
                foods.add(newPizza); // add that pizza into the order

            } else if (choice == 2) {

                ArrayList<String> allowedToppings = new ArrayList<>(Arrays.asList("bolognese", "marinara", "primavera", "tomato"));
                System.out.println("Topping Options:");
                System.out.println("BOLOGNESE");
                System.out.println("MARINARA");
                System.out.println("PRIMAVERA");
                System.out.println("TOMATO");
                System.out.println("Enter topping (you can only choose one or enter blank for no toppings):");
                String choices = input.nextLine();
                Pasta newPasta; // not sure whether toppings are needed so not initializing first
                if (allowedToppings.contains(choices.toLowerCase().trim())) { // make sure topping is available
                    newPasta = new Pasta(choices.toLowerCase().trim());
                } else { // if not available or no topping is needed
                    newPasta = new Pasta("none");
                }
                foods.add(newPasta); // add that pasta into the order

            } else if (choice == 3) {
                exit = true; // to end this loop
            }
        }
    }

    @Override
    public double totalCost() {

        double cost = 0.00;

        for (FoodItem food : foods){ // loop through all the foods in an order
            cost += food.calculatePrice(); // total up their price
        }
        return cost;
    }

    @Override
    public MealType mealType() {

        boolean meat = false;
        boolean vegetarian = false;

        // make everything false first, only true if its present
        for (FoodItem food : foods){
            if (food.getMealType() == MealType.MEAT){
                meat = true;
            } else if (food.getMealType() == MealType.VEGETARIAN) {
                vegetarian = true;
            }
        }
        if (meat){ // meat has higher prioritisation, then vegetarian then vegan
            return MealType.MEAT;
        } else if (vegetarian) {
            return MealType.VEGETARIAN;
        } else {
            return MealType.VEGAN;
        }
    }

    @Override
    public void printOrder() {
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Customer Address: " + getDeliveryAddress());
        System.out.println("Customer Phone: " + getCustomerContactNumber());
        System.out.println("Items ordered:");
        System.out.println("================================");
        for (FoodItem food : foods){ // loop through all the foods in an order to print out all the food details
            System.out.println(food);
        }
        System.out.println("Total Order Price: " + totalCost());
        System.out.println("Order Meal Type: " + mealType());
        System.out.println();
    }

    /**
     * getter method
     * @return customer's name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * getter method
     * @return customer's contact number
     */
    public int getCustomerContactNumber() {
        return customerContactNumber;
    }

    /**
     * getter method
     * @return customer's delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

}