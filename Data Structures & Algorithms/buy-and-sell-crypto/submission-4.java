class Solution {
    public int maxProfit(int[] prices) {
        int p1 = 0; 
        //int p2 = 0; 
        int max = 0; 

        for (int p2 = 0; p2 < prices.length; p2++) {
            if (prices[p1] < prices[p2]) {
                int currProfit = prices[p2] - prices[p1]; 
                max = Math.max(currProfit, max); 
            } else {
                p1 = p2; 
            }
        }

        return max; 
    }
}
