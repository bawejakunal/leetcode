// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);  // either sell the stock or keep as it is
            hold = Math.max(hold, cash - prices[i]);        // either hold the stock or buy another one
        }
        return cash;
    }
}