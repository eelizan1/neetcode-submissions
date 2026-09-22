class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>(); 
        backtrack(nums, results, 0, new ArrayList<>()); 

        return results;
    }

    private void backtrack(int[] nums, List<List<Integer>> results, int index, List<Integer> current) {
        if (index == nums.length) {
            results.add(new ArrayList<>(current)); 
            return; 
        }

        current.add(nums[index]);  
        backtrack(nums, results, index + 1, current); 
        current.remove(current.size() - 1); 

        backtrack(nums, results, index + 1, current); 
    }
}
