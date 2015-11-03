/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/



// too simple 

/*************** My solution*******************/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
        return 0;
        
        int len = prices.length;
        int profit = 0;
        int temp = 0;
        for(int i = 0; i < len - 1; i++)   {
            if((temp = prices[i + 1] - prices[i]) > 0)
            profit += temp;
        }
        
        return profit;
	}
}