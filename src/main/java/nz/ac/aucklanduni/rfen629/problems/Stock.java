package nz.ac.aucklanduni.rfen629.problems;

import java.util.Arrays;

/**
 * @author Raymond Feng (raymond@fundafuture.co.nz)
 */
public class Stock {

    /*
     * LeetCode 122
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
     */
    public int maxProfitII(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                // Buy at price[i], sell at price[i + 1]
                sum += prices[i + 1] - prices[i];
            }
        }

        return sum;
    }

    /*
     * LeetCode 121
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfitI(int[] prices) {
        int min = prices[0], maxDiff = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxDiff) {
                maxDiff = prices[i] - min;
            } else {
                min = Math.min(prices[i], min);
            }
        }

        return maxDiff;
    }
}
