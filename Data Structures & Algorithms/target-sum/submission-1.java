class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0, new HashMap<>()); 
    }

    public static int helper(int[] nums, int target, int index, int totalSoFar, HashMap<String,Integer> memo) {
        if (index == nums.length) {
            return totalSoFar == target ? 1 : 0; 
        }

        String key = index + "," + totalSoFar; 
        if (memo.containsKey(key)) return memo.get(key); 

        int add = helper(nums, target, index + 1, totalSoFar + nums[index], memo); 
        int minus = helper(nums, target, index + 1, totalSoFar - nums[index], memo); 

        memo.put(key, add + minus);
        return memo.get(key); 
    }

}
