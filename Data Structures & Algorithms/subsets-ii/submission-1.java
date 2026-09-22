class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>(); 

        backtrack(nums, result, current, 0); 

        return result; 
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current)); 
            return; 
        }

        current.add(nums[index]); 
        backtrack(nums, result, current, index + 1); 
        current.remove(current.size() - 1); 

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(nums, result, current, index + 1);
    }
}
