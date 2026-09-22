class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }

        int matched = 0; 
        int start = 0; 
        int currMinLength = Integer.MAX_VALUE; 
        String res = ""; 

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end); 

            if (map.containsKey(c)) {
                map.put(c, map.get(c) -1); 
                if (map.get(c) == 0) matched++; 
            }

            while (matched == map.size()) {
                if ((end - start + 1) < currMinLength) {
                    currMinLength = (end - start + 1); 
                    res = s.substring(start, end + 1); 
                }

                char startChar = s.charAt(start); 
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) matched--; 
                    map.put(startChar, map.get(startChar) + 1); 
                }

                start++; 
            }
        }

        return res; 
    }
}
