class Solution {
    public HashMap<Integer, Integer> memo = new HashMap<>(); 

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0; 
        if (amount < 0) return -1; 
        if (memo.containsKey(amount)) return memo.get(amount); 

        int min = Integer.MAX_VALUE; 
        for (int coin : coins) {
            int remaining = amount - coin; 
            int currCoins = coinChange(coins, remaining); 

            if (currCoins == -1) continue; 
            currCoins += 1; 
            min = Math.min(min, currCoins); 
        }
        
        min = min == Integer.MAX_VALUE ? -1 : min;
        memo.put(amount, min);

        return min; 
    }
}
