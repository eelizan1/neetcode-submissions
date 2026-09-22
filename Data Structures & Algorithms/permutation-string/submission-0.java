public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();

        // build the initial window
        for (int i = 0; i < windowSize; i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // compare initial window
        if (Arrays.equals(s1Count, windowCount)) return true;

        // slide the window across s2
        for (int i = windowSize; i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++; // add new char to window
            windowCount[s2.charAt(i - windowSize) - 'a']--; // remove leftmost char

            if (Arrays.equals(s1Count, windowCount)) return true;
        }

        return false;
    }
}
