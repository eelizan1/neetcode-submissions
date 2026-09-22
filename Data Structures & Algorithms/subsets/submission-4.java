class Solution {
    private List<List<Integer>> res; 
    private List<Integer> curr; 

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>(); 
        curr = new ArrayList<>(); 

        backtrack(0, nums); 
        return res; 
    }

    private void backtrack(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        // dont pick 
        backtrack(index + 1, nums); 

        // pick 
        curr.add(nums[index]); 
        backtrack(index + 1, nums); 
        curr.remove(curr.size() - 1); 
    }
}
