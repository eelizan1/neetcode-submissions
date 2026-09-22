class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>(); 
        int left = 0;
        int res = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 

            while (set.contains(c)) {
                set.remove(s.charAt(left)); 
                left++; 
            }

            set.add(c); 

            res = Math.max(res, set.size()); 
        }

        return res; 
    }
}
