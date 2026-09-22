class Solution {
    private List<List<Integer>> res = new ArrayList<>(); 
    private List<Integer> curr = new ArrayList<>(); 

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums); 
        return res;
    }

    private void backtrack(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        curr.add(nums[index]); 
        backtrack(index + 1, nums); 

        curr.remove(curr.size() - 1); 
        backtrack(index + 1, nums); 
    }
}
