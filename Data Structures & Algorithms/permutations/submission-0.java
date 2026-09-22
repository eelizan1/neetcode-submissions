class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>(); 
        Set<Integer> used = new HashSet<>(); 

        backtrack(nums, output, current, used); 

        return output; 
    }

    public void backtrack(int[] nums, List<List<Integer>> output, List<Integer> current, Set<Integer> used) {
        if (current.size() == nums.length) {
            output.add(new ArrayList<>(current)); 
            return; 
        }

        for (int num : nums) {
            if (used.contains(num)) continue; 

            current.add(num); 
            used.add(num); 
            backtrack(nums, output, current, used); 

            current.remove(current.size() - 1); 
            used.remove(num); 
        }
    }
}
