class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int charsMatched = 0; 
        int start = 0; 
        int minLength = Integer.MAX_VALUE;
        String res = ""; 

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end); 

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1); 
                if (map.get(c) == 0) charsMatched++; 
            }

            while (charsMatched == map.size()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    res = s.substring(start, end + 1); 
                }

                char charToDelete = s.charAt(start); 
                if (map.containsKey(charToDelete)) {
                    if (map.get(charToDelete) == 0) charsMatched--;
                    map.put(charToDelete, map.get(charToDelete) + 1);
                }

                start++;
            }
        }

        return res; 

    }
}
