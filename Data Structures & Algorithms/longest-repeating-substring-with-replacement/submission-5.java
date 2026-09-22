class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        int start = 0; 
        int max = 0; 

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end); 
            map.put(endChar, map.getOrDefault(endChar, 0) + 1); 

            if ((end - start + 1) - Collections.max(map.values()) > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);

                start++; 
            }

            max = Math.max(max, (end - start + 1)); 
        }

        return max; 
    }
}

