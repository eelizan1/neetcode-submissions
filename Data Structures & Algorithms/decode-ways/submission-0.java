class Solution {
    public int numDecodings(String s) {
        return helper(s, 0, new HashMap<>()); 
    }

    public int helper(String s, int index, HashMap<Integer, Integer> memo) {
        if (index == s.length()) return 1; 

        if (s.charAt(index) == '0') return 0; 

        if (index == s.length() - 1) return 1; 

        if (memo.containsKey(index)) return memo.get(index); 

        int count = helper(s, index + 1, memo); 
        int doubleDigit = Integer.valueOf(s.substring(index, index + 2)); 
        if (doubleDigit <= 26) {
            count += helper(s, index + 2, memo); 
        }

        memo.put(index, count); 
        return count; 
    }
}
