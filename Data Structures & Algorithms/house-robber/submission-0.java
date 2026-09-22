class Solution {
    public HashMap<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
       int index = 0; 
       return dp(nums, index); 
    }

    private int dp(int[] nums, int index) {
        if (index >= nums.length) return 0; 
        if (memo.containsKey(index)) return memo.get(index); 

        int firstChoice = nums[index] + dp(nums, index + 2); 
        int secondChoice = dp(nums, index + 1); 

        memo.put(index, Math.max(firstChoice, secondChoice)); 

        return memo.get(index);
    }
}
