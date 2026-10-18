class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 

        backtrack(nums, res, new ArrayList<>(), 0);

        return res;  
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        // not take 
        backtrack(nums, res, curr, index + 1); 

        // take 
        curr.add(nums[index]); 
        backtrack(nums, res, curr, index + 1); 

        // remove 
        curr.remove(curr.size() - 1); 
    }
}
