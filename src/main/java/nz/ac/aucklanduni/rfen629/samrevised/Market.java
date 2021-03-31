package nz.ac.aucklanduni.rfen629.samrevised;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Raymond Feng (rf.raymondfeng@gmail.com)
 */
public class Market {

    /**
     * An order that can be placed in a market.
     */
    public static class Order {

        /**
         * The amount traded in this order.
         */
        private final int amount;

        /**
         * The number of seconds since epoch when the order is made.
         */
        public final long timestamp;

        /**
         * If the order has been placed on the market.
         */
        private boolean isFulfilled;

        public Order(int amount) {
            this.amount = amount;
            timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        }

        /*
         * Default getter/setter methods
         */

        public void setFulfilled(boolean isFulfilled) {
            this.isFulfilled = isFulfilled;
        }

        public boolean isFulfilled() {
            return isFulfilled;
        }

    }

    /**
     * Set of all currently operating markets.
     */
    public static Set<Market> operatingMarkets = new HashSet<>();

    /**
     * The name of this market's commodity.
     */
    private final String name;

    /**
     * The current price of the market's commodity.
     */
    private double currentPrice;

    /**
     * List of all orders made in this market.
     */
    private final List<Order> orders = new ArrayList<>();


    public Market(String productName, double startingPrice) {
        name = productName;
        currentPrice = startingPrice;
    }

    /**
     * Adds an order to this market.
     */
    public void addOrder(Order order) {
        orders.add(order);
        order.setFulfilled(true);
        currentPrice += Math.signum(order.amount) * Math.exp(Math.abs(order.amount / (double) getTradeVolume()[3]));
    }

    /**
     * Returns the trading volumes of this market. This is the sum of all exchanges in this market.
     *
     * Index 0 is total volume, Index 1 amount bought, Index 2 amount sold, Index 3 net amount.
     */
    public int[] getTradeVolume() {
        int total = 0, buy = 0, sell = 0, net = 0;

        for (Order order : orders) {
            total += Math.abs(order.amount);
            buy += Math.max(order.amount, 0);
            sell += Math.min(order.amount, 0);
            net += order.amount;
        }

        return new int[] {total, buy, -sell, net};
    }

    /**
     * Prints a summary of this market at this point
     */
    public void printDesc() {
        int[] volume = getTradeVolume();
        System.out.printf("%ss: currently trading at $%.2f, (%d volume, %d buy, %d sell) with %d orders\n",
                          name, currentPrice, volume[0], volume[1], volume[2], orders.size());
    }

}
