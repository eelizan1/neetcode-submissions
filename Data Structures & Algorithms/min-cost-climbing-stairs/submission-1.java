class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>(); 

    public int minCostClimbingStairs(int[] cost) {
        return minCost(cost.length, cost); 
    }

    private int minCost(int i, int[] cost) {
        if (memo.containsKey(i)) return memo.get(i); 

        if (i < 2) return 0; 

        int oneStep = cost[i - 1] + minCost(i - 1, cost); 
        int twoStep = cost[i - 2] + minCost(i - 2, cost);

        memo.put(i, Math.min(oneStep, twoStep)); 

        return memo.get(i); 
    }
}
