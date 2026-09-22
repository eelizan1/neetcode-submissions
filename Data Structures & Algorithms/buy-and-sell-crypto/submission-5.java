class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        int l = 0; // buy 
        int r = 0; // sell 

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int currProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, currProfit); 
                r++; // can we do better? 
            } else {
                l = r; 
                r++; 
            }
        }

        return maxProfit; 
    }
}
