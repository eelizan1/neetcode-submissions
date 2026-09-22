class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ways = 0; 

        ways += helper(nums, target, 0, 0, new HashMap<>()); 

        return ways; 
    }

    private int helper(int[] nums, int target, int i, int totalSoFar, HashMap<String, Integer> memo) {
        if (i == nums.length) {
            return totalSoFar == target ? 1 : 0; 
        }

        String key = i + "," + totalSoFar; 
        if (memo.containsKey(key)) return memo.get(key); 

        int add = helper(nums, target, i + 1, totalSoFar + nums[i], memo); 
        int subtract = helper(nums, target, i + 1, totalSoFar - nums[i], memo); 

        memo.put(key, add + subtract); 
        return memo.get(key);
    }
}
