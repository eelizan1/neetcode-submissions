class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(); 
        int max = 0; 
        int windowStart = 0; 

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd); 
            map.put(c, map.getOrDefault(c, 0) + 1); 

            while ((windowEnd - windowStart + 1) - Collections.max(map.values()) > k) {
                char startChar = s.charAt(windowStart); 
                map.put(startChar, map.get(startChar) - 1); 

                windowStart++; 
            }

            max = Math.max(max, (windowEnd - windowStart + 1)); 
        }

        return max; 
    }
}
