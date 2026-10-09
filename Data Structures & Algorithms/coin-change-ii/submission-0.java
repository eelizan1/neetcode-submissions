class Solution {
    public int change(int amount, int[] coins) {
        return dp(amount, coins, 0, new HashMap<>()); 
    }

    private int dp(int amount, int[] coins, int index, HashMap<String, Integer> memo) {
        if (amount < 0) return 0; 
        if (amount == 0) return 1; 

        String key = amount + "," + index; 
        if (memo.containsKey(key)) return memo.get(key); 

        int count = 0; 
        for (int i = index; i < coins.length; i++) {
            int remainder = amount - coins[i]; 
            count += dp(remainder, coins, i, memo); 
        }

        memo.put(key, count); 
        return count; 
    }
}
