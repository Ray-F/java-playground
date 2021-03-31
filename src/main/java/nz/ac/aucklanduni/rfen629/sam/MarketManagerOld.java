package nz.ac.aucklanduni.rfen629.sam;

public class MarketManagerOld {
    public static void main(String[] args) {

        // Give market info to the MarketInfo class
        MarketInfoOld.giveInfo("oranges", 2);
        MarketInfoOld.giveInfo("apples", 4.5);
        MarketInfoOld.giveInfo("pears", 6);
        MarketInfoOld.giveInfo("balloons", 6);


        // Price increases seen as a result of a large increase in orders do not take into account the fact
        // that there is a limited supply
        MarketOld.newOrder("oranges", 10);
        MarketOld.newOrder("oranges", 1000);
        MarketOld.newOrder("oranges", 10000);
        MarketOld.newOrder("oranges", 100000);

        // Negative price increases correspond to a sale of the product into the market
        // Positive price increases, on the other hand, correspond to buying
        MarketOld.newOrder("apples", 10);
        MarketOld.newOrder("apples", 30);
        MarketOld.newOrder("apples", -20);

        MarketOld.newOrder("pears", 10);
        MarketOld.newOrder("pears", 10);
        MarketOld.newOrder("pears", 10);
        MarketOld.newOrder("pears", 10);

        // Get all details about the markets currently operating
        MarketInfoOld.getAllDetails();

    }
}
