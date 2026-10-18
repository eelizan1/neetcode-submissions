class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>(); 

        backtrack(nums, res, new ArrayList<>(), 0);

        return res;  
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        // take 
        curr.add(nums[index]); 
        backtrack(nums, res, curr, index + 1); 
        // remove 
        curr.remove(curr.size() - 1); 

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) index++; 

        // not take 
        backtrack(nums, res, curr, index + 1); 
    }
}
