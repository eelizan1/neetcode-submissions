class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int start = 0; 
        int max = 0; 

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end); 

            while (set.contains(endChar)) {
                set.remove(s.charAt(start)); 
                start++; 
            }

            set.add(endChar); 
            max = Math.max(max, set.size()); 
        }

        return max; 
    }
}
