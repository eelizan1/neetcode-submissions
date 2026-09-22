class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 
        int left = 0; 
        int longest = Integer.MIN_VALUE; 

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); 

            

            while (set.contains(c)) {
                char leftChar = s.charAt(left); 
                set.remove(leftChar); 
                left++; 
            }

            set.add(c); 

            longest = Math.max(longest, (right - left + 1)); 
        }

        return longest == Integer.MIN_VALUE ? 0 : longest; 
    }
}
