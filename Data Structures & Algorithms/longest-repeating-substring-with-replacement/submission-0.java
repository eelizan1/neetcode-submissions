class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        int left = 0; 
        int max = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            map.put(c, map.getOrDefault(c, 0) + 1); 

            // window condition 
            while ((i - left + 1) - Collections.max(map.values()) > k) {
                // shrink window 
                char leftChar = s.charAt(left); 
                map.put(leftChar, map.get(leftChar) - 1); 
                left++; 
            }

            // grow window 

            // check res 
            max = Math.max(max, (i - left + 1));     
        }

        return max; 
    }
}
