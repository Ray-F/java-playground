package nz.ac.aucklanduni.rfen629.sam;

public class MarketOld {

    // Initialise price information
    private static double currentPrice;
    private static double nextPrice;

    // Initialise order details
    private static int orderCount;
    private static int netOrderCount;
    private static int totalOrders;

    // Initialise product details
    private static String[] productDetails = new String[3];
    private static int productNumber;

    public MarketOld() {
        // Explicit declaration of an empty constructor
    }

    public static void newOrder(String productName, int orderCount) {

        // Get the product index number and the details regarding the product requested
        productNumber = MarketInfoOld.stringList.indexOf(productName);
        productDetails = MarketInfoOld.getDetails(productNumber);
        currentPrice = Double.valueOf(productDetails[1]);

        // Get the order info from the MarketInfo class
        totalOrders = MarketInfoOld.totalOrders.get(productNumber);
        netOrderCount = MarketInfoOld.netOrderCount.get(productNumber);
        MarketOld.orderCount = orderCount;

        // Increment the total number of orders by the order amount
        // Apply a function to determine the next price
        totalOrders += orderCount;
        if (totalOrders != 0) {

            // This function only operates if total orders is greater than zero so as to avoid diving by zero
            // Note that this only applies for an order count of zero
            nextPrice = currentPrice + Math.signum(orderCount) * Math.exp(Math.abs(orderCount / (double) totalOrders));

        }

        // Set the new market price after the order has been made
        netOrderCount++;
        setNewPrice(productDetails, nextPrice);

        // Update the order information in the MarketInfo class
        MarketInfoOld.totalOrders.set(productNumber, totalOrders);
        MarketInfoOld.netOrderCount.set(productNumber, netOrderCount);
    }

    public static double averageOrder(int totalOrders, int netOrderCount) {
        // Return the average order size if requested
        return (double)totalOrders / netOrderCount;
    }

    public static void setNewPrice(String[] productDetails, double newPrice) {
        // Set the new market price after the order has been made
        currentPrice = newPrice;
        MarketInfoOld.doubleList.set(productNumber, Double.valueOf(currentPrice));
    }

}
