class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> currSubset = new ArrayList<>(); 

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums); 
        return result;
    }

    private void backtrack(int index, int[] nums) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(currSubset)); 
            return; 
        }

        backtrack(index + 1, nums); 

        currSubset.add(nums[index]); 
        backtrack(index + 1, nums); 
        currSubset.remove(currSubset.size() - 1); 
    }
}
