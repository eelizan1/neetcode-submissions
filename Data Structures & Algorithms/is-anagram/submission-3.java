class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray(); 
        char[] tCharArray = t.toCharArray(); 

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        String sSorted = new String(sCharArray); 
        String tSorted = new String(tCharArray); 

        if (!sSorted.equals(tSorted)) return false; 

        return true; 
    }
}
