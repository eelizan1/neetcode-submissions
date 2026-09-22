class Solution {
    public boolean canJump(int[] nums) {
        return dp(nums, 0, new HashMap<>());
    }

    private boolean dp(int[] nums, int index, HashMap<Integer, Boolean> memo) {
        if (index == nums.length - 1) return true; 
        if (index > nums.length - 1) return false;
        if (memo.containsKey(index)) return memo.get(index); 

        int furthest = index + nums[index];
        for (int next = index + 1; next <= furthest; next++) {
            if (dp(nums, next, memo)) {
                memo.put(index, true);
                return true;
            }
        }

        memo.put(index, false); 
        return false; 
    }
}
