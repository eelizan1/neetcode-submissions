class Solution {
    public String longestPalindrome(String s) {
        int start = 0; 
        int end = 0; 

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expandAroundCenter(s, i, i); 
            int evenLength = expandAroundCenter(s, i, i + 1); 

            int currLength = Math.max(oddLength, evenLength); 

            if (currLength > (end - start)) {
                start = i - (currLength - 1) / 2; 
                end = i + currLength / 2; 
            }
        }

        return s.substring(start, end + 1); 
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left; 
        int R = right; 

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--; 
            R++; 
        }

        return R - L - 1; 
    }
}
