class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>(); 

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0; 
        if (amount < 0) return -1; 
        if (memo.containsKey(amount)) return memo.get(amount); 

        int minCoins = Integer.MAX_VALUE; 
        for (int coin : coins) {
            int remaining = amount - coin; 
            int numCoins = coinChange(coins, remaining); 

            if (numCoins != -1) {
                minCoins = Math.min(minCoins, numCoins + 1); 
            }
        }

        minCoins = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        memo.put(amount, minCoins); 
        return minCoins; 
    }
}
