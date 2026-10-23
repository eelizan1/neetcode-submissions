class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int start = 0; 
        int max = 0; 

        for (int i = 0; i < s.length(); i++) {
            char endChar = s.charAt(i); 
            
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
