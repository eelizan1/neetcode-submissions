class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>(); 
        List<Integer> comb = new ArrayList<>(); 

        backtrack(target, comb, 0, nums, results); 

        return results; 
    }

    private void backtrack(int target, List<Integer> comb, int start, int nums[], List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(comb)); 
            return; 
        }

        if (target < 0) return; 

        for (int i = start; i < nums.length; i++) {
            comb.add(nums[i]); 
            int remaining = target - nums[i]; 
            backtrack(remaining, comb, i, nums, results); 
            comb.remove(comb.size() - 1); 
        }
    }
}
