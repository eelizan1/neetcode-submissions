class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; 

        int n = s.length();
        char[] sChar = s.toCharArray(); 
        char[] tChar = t.toCharArray(); 

        Arrays.sort(sChar); 
        Arrays.sort(tChar); 

        for (int i = 0; i < n; i++) {
            if (sChar[i] != tChar[i]) return false; 
        }

        return true; 
    }
}
