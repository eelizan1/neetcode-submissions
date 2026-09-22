class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int max = 0; 
        int start = 0; 

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end); 
            
            while (set.contains(endChar)) {
                char startChar = s.charAt(start); 
                set.remove(startChar); 
                start++; 
            }

            set.add(endChar); 
            max = Math.max(max, set.size()); 
        }

        return max; 
    }
}
