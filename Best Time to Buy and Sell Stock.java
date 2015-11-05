/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/



/****************My solution****************/
public class Solution {
    public int maxProfit(int[] prices) {

        // int[] diff = new int[prices.length];
        int profit = 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++)  {
            if(profit <0)   {
                profit = 0; 
            }
            profit = profit + prices[i] - prices[i - 1];
            if(profit >max)
            max = profit;
        }
        
        return max;
        
    }
}