class Solution {
    public String longestPalindrome(String s) {
        int maxStart = 0;
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int odd  = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            
            int length = Math.max(odd, even);
            
            if (length > maxLen) {
                maxLen   = length;
                maxStart = i - (length - 1) / 2;
            }
        }
        
        return s.substring(maxStart, maxStart + maxLen);
    }
    
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}