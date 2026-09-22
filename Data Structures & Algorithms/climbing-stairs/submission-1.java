class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>(); 
    public int climbStairs(int n) {
        if (n == 0) return 1; 
        if (n < 0) return 0; 
        if (memo.containsKey(n)) return memo.get(n); 

        int oneStep = climbStairs(n - 1); 
        int twoStep = climbStairs(n - 2); 

        memo.put(n, oneStep + twoStep);

        return memo.get(n);
    }
}
