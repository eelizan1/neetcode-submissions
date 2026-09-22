class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        int index = 0; 
        Arrays.sort(nums);

        backtrack(res, curr, index, nums); 
        return res; 
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr, int index, int[] nums) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        curr.add(nums[index]); 
        backtrack(res, curr, index + 1, nums); 

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index++; 

        curr.remove(curr.size() - 1); 
        backtrack(res, curr, index + 1, nums); 
    }
}
