class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0, new HashMap<>());
    }

    private int helper(String text1, String text2, int i, int j, HashMap<String, Integer> memo) {
        if (i == text1.length() || j == text2.length()) return 0;

        String key = i + "," + j; 
        if (memo.containsKey(key)) return memo.get(key); 

        if (text1.charAt(i) == text2.charAt(j)) {
            return helper(text1, text2, i + 1, j + 1, memo) + 1; 
        }

        int branchLeft = helper(text1, text2, i + 1, j, memo); 
        int branchRight = helper(text1, text2, i, j + 1, memo); 

        memo.put(key, Math.max(branchLeft, branchRight)); 
        return memo.get(key);
    }
}
