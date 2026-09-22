class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0; 

        for (int sell = 0; sell < prices.length; sell++) {
            if (prices[buy] < prices[sell]) {
                max = Math.max(max, prices[sell] - prices[buy]); 
            } else {
                buy = sell; 
            }
        }

        return max; 
    }
}
