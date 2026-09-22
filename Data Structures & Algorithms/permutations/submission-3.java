class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 
        HashSet<Integer> set = new HashSet<>(); 

        dfs(res, curr, set, nums); 
        return res; 
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, HashSet<Integer> set, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        for (int num : nums) {
            if (set.contains(num)) continue; 
            set.add(num); 

            curr.add(num); 
            dfs(res, curr, set, nums); 

            curr.remove(curr.size() - 1); 
            set.remove(num);
        }
    }
}
