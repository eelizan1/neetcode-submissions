class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        
        int startFirst = robHelper(nums, 0, nums.length - 1, new HashMap<>()); 
        int startSecond = robHelper(nums, 1, nums.length, new HashMap<>()); 

        return Math.max(startFirst, startSecond); 
    }

    private int robHelper(int[] nums, int index, int length, Map<Integer, Integer> memo) {
        if (index >= length) return 0; 
        if (memo.containsKey(index)) return memo.get(index); 

        int robFirst = nums[index] + robHelper(nums, index + 2, length, memo); 
        int dontRobFirst = robHelper(nums, index + 1, length, memo); 

        memo.put(index, Math.max(robFirst, dontRobFirst)); 

        return memo.get(index); 
    }
}
