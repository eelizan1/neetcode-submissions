class Solution {
    public int countSubstrings(String s) {
        int count = 0; 

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i); 
            count += expand(s, i, i + 1); 
        }

        return count; 
    }

    private int expand(String s, int left, int right) {
        int L = left; 
        int R = right; 
        int currCount = 0; 

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            currCount++; 
            L--; 
            R++; 
        }

        return currCount; 
    }
}
