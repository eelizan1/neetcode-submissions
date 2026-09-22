class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int longest = 0; 
        int left = 0; 

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); 

            while(set.contains(c)) {
                char leftChar = s.charAt(left); 
                set.remove(leftChar); 
                left++; 
            }

            set.add(c); 
            longest = Math.max(longest, set.size()); 
            
        }

        return longest; 
    }
}
