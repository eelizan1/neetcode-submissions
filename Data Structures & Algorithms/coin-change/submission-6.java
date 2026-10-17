class Solution {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount, new HashMap<Integer, Integer>()); 
    }

    private int dp(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        if (amount == 0) return 0; 
        if (amount < 0) return -1; 
        if (memo.containsKey(amount)) return memo.get(amount); 

        int minCoins = Integer.MAX_VALUE; 
        for (int coin : coins) {
            int remaining = amount - coin; 
            int numCoins = dp(coins, remaining, memo); 

            if (numCoins == -1) continue; 

            minCoins = Math.min(minCoins, numCoins + 1);  
        }

        minCoins = minCoins == Integer.MAX_VALUE ? -1 : minCoins; 
        memo.put(amount, minCoins); 

        return minCoins; 
    }
}
