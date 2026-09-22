class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>(); 

        Arrays.sort(candidates); 
        backtrack(candidates, 0, target, res, curr); 

        return res; 
    }

    private void backtrack(int[] candidates, int index, int target, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr)); 
            return; 
        }

        if (target < 0) return; 

        for (int i = index; i < candidates.length; i++) {
            
            if (i > index && candidates[i] == candidates[i - 1]) continue; 
            curr.add(candidates[i]); 
            int remaining = target - candidates[i]; 
            backtrack(candidates, i + 1, remaining, res, curr); 

            curr.remove(curr.size() - 1); 
        }
    }
}
