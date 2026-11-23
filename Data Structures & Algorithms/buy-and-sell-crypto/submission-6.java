class Solution {
    public int maxProfit(int[] prices) {
        int max = 0; 
        int buy = 0; 

        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] > prices[buy]) {
                int curr = prices[sell] - prices[buy]; 
                max = Math.max(max, curr); 
            } else {
                buy = sell; 
            }
        }

        return max; 
    }
}
