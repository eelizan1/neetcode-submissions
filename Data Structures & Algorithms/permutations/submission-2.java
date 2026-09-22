class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>(); 
        HashSet<Integer> used = new HashSet<>(); 

        dfs(current, used, result, nums); 

        return result; 
    }

    private void dfs(List<Integer> current, Set<Integer> used, List<List<Integer>> result, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); 
            return; 
        }

        for (int num : nums) {
            if (used.contains(num)) continue; 

            current.add(num); 
            used.add(num); 
            dfs(current, used, result, nums); 

            current.remove(current.size() - 1); 
            used.remove(num); 
        }
    }
}
