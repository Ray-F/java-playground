package nz.ac.aucklanduni.rfen629.samrevised;

import java.util.Arrays;

import static nz.ac.aucklanduni.rfen629.samrevised.Market.Order;
import static nz.ac.aucklanduni.rfen629.samrevised.Market.operatingMarkets;

/**
 * @author Raymond Feng (rf.raymondfeng@gmail.com)
 */
public class MarketManager {

    public static void main(String[] args) {
        // Define a set of different markets
        Market orangeMarket = new Market("Orange", 2);
        Market appleMarket = new Market("Apple", 4.5);
        Market pearMarket = new Market("Pear", 6);

        // Add them to the list of operating markets
        operatingMarkets.addAll(Arrays.asList(orangeMarket, appleMarket, pearMarket));

        orangeMarket.addOrder(new Order(10));
        orangeMarket.addOrder(new Order(1_000));
        orangeMarket.addOrder(new Order(10_000));
        orangeMarket.addOrder(new Order(100_000));

        appleMarket.addOrder(new Order(10));
        appleMarket.addOrder(new Order(30));
        appleMarket.addOrder(new Order(-20));

        pearMarket.addOrder(new Order(10));
        pearMarket.addOrder(new Order(10));
        pearMarket.addOrder(new Order(10));
        pearMarket.addOrder(new Order(10));

        // Print the description for each market
        operatingMarkets.forEach(Market::printDesc);
    }

}
