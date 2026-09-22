class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE; 
        HashMap<Character, Integer> map = new HashMap<>(); 
        int left = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 

            map.put(c, map.getOrDefault(c, 0) + 1); 
            while ((i - left + 1) - Collections.max(map.values()) > k) {
                char leftChar = s.charAt(left); 
                map.put(leftChar, map.get(leftChar) - 1); 
                left++; 
            }

            max = Math.max(max, (i - left + 1)); 
        }

        return max; 
    }
}
