class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int matched = 0;

        // Build frequency map
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int end = 0; end < s2.length(); end++) {
            char endChar = s2.charAt(end);

            // Expand window
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);

                if (map.get(endChar) == 0) {
                    matched++;
                }
            }

            // All unique characters matched
            if (matched == map.size()) {
                return true;
            }

            // Shrink window when it gets too large
            if (end - start + 1 >= s1.length()) {
                char startChar = s2.charAt(start);

                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        matched--;
                    }

                    map.put(startChar, map.get(startChar) + 1);
                }

                start++;
            }
        }

        return false;
    }
}