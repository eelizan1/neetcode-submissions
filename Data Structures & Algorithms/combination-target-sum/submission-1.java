class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 

        backtrack(nums, target, res, curr, 0); 
        return res; 
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        if (target < 0) {
            return; 
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]); 
            int remaining = target - nums[i]; 
            backtrack(nums, remaining, res, curr, i); 
            curr.remove(curr.size() - 1); 
        }
    }
}
