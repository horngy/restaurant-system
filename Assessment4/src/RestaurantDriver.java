import java.util.Scanner;
import java.util.ArrayList;

/**
 *This is the main class that runs the program
 * @author Teh Yee Hong
 * @version ver 1.0.0
 */

public class RestaurantDriver
{
    private static final ArrayList<Order> allOrders = new ArrayList<>(); // an array list to store orders

    /**
     *This is the kick-start method
     * @param args An array of string passed in as command line parameters
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean exit = false; // to always run the code until 4 is inputted
        while (!exit){
            System.out.println("Welcome to the Take-Away Management Portal");
            System.out.println("==========================================");
            System.out.println("Please select an option:");
            System.out.println("1. Enter Order Details");
            System.out.println("2. Deliver an Order");
            System.out.println("3. Display all items and customer details in the Order");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            if (choice == 1){
                createOrder();
            } else if (choice == 2) {
                deliverOrder();
            } else if (choice == 3) {
                displayOrders();
            } else if (choice == 4) {
                exit = true; //to leave the loop
            }
        }
    }

    /**
     *This is the method to create an order
     */
    private static void createOrder() {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter customer details");
        System.out.println("Enter customer name:");
        String customerName = input.nextLine();
        System.out.println("Enter customer address:");
        String deliveryAddress = input.nextLine();
        System.out.println("Enter customer phone number:");
        int customerContactNumber = input.nextInt();
        System.out.println();

        Order newOrder = new Order(customerName, customerContactNumber, deliveryAddress); // create new order
        newOrder.addFoodItem(); // to choose pizza or pasta
        allOrders.add(newOrder); // add that particular order into order list
    }

    /**
     * This is the method to display all orders
     */
    private static void displayOrders(){

        if (allOrders.isEmpty()){ // if there are no order
            System.out.println();
            System.out.println("There are no orders currently");
            System.out.println();
        } else { // if there are still any order
            System.out.println();
            System.out.println("You have selected to display all Orders in the System");
            System.out.println();
            for (int i = 0; i < allOrders.size(); i++){ // to loop the array list and print out all order one by one
                System.out.println("Order " + (i+1) + ":");
                allOrders.get(i).printOrder();
            }
        }
    }

    /**
     * This is the method to deliver the first order in the array list
     */
    private static void deliverOrder(){

        if (allOrders.isEmpty()){ // if there are no order
            System.out.println();
            System.out.println("There are no orders currently");
            System.out.println();

        } else {
            System.out.println();
            System.out.println("You have selected to deliver an Order");
            System.out.println();
            System.out.println("Delivering " + allOrders.get(0).getCustomerName() + "'s order to " + allOrders.get(0).getDeliveryAddress());

            allOrders.get(0).printOrder(); // details of the first order
            allOrders.remove(0); // remove that particular order as it is being delivered
            System.out.println("There are now " + allOrders.size() + " order(s) pending delivery"); // orders left

            System.out.println();
        }
    }
}