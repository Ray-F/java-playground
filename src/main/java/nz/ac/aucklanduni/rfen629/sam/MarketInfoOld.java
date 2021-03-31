package nz.ac.aucklanduni.rfen629.sam;


import java.util.ArrayList;
import java.util.Arrays;

public class MarketInfoOld {

    // Initialise the starting price and the number of markets currently in operation
    private static double startingPrice;
    private static int marketCount;

    // Initialise ArrayLists containing the names of the markets and the market prices
    static ArrayList<String> stringList = new ArrayList<>();
    static ArrayList<Double> doubleList = new ArrayList<>();

    // Initialise protected ArrayLists containing information about the orders being made
    // This information can be accessed from the market class
    protected static ArrayList<Integer> totalOrders = new ArrayList<>();
    protected static ArrayList<Integer> netOrderCount = new ArrayList<>();

    // This method allows information about markets to be passed into it, and effectively initialises the markets
    public static void giveInfo(String productName, double startingPrice) {

        // Add the market's name and starting price to the ArrayLists
        stringList.add(productName);
        doubleList.add(startingPrice);

        // Initialise the total orders and net order count explicitly
        totalOrders.add(0);
        netOrderCount.add(0);
        marketCount++;
    }

    // Get details about a specific market
    public static String[] getDetails(int index) {

        // Get the details for a single product
        String firstVar = stringList.get(index);
        double secondVar = doubleList.get(index);

        // Organise these details into an array and return the result
        String[] outputArray = {firstVar, String.valueOf(secondVar)};
        return outputArray;
    }

    // This method allows the user to retrieve details about all markets currently operating
    public static void getAllDetails() {

        // Print the array as a string for each market
        for (int i = 0; i < marketCount; i++) {
            System.out.println(Arrays.toString(getDetails(i)));
        }

    }

}