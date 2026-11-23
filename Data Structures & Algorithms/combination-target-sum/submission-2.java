class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>(); 

        backtrack(nums, target, 0, 0, current, result); 

        return result; 
    }

    private void backtrack(int[] nums, int target, int total, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == total) {
            result.add(new ArrayList<>(current)); 
            return; 
        }

        if (index >= nums.length || total > target) return; 

        // include i 
        current.add(nums[index]); 
        backtrack(nums, target, total + nums[index], index, current, result); 

        // not include i 
        current.remove(current.size() - 1); 
        backtrack(nums, target, total, index + 1, current, result); 
    }
}
