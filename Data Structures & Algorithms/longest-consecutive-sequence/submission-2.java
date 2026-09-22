class Solution {
    public int longestConsecutive(int[] nums) {
        int longestCount = 0; 
        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) {
            set.add(num); 
        }

        for (int num : nums) {
            int start = num - 1; 
            if (set.contains(start)) continue; 

            int currentNum = num; 
            int currentStreak = 1; 

            while (set.contains(currentNum + 1)) {
                currentStreak++; 
                currentNum++; 
            }

            longestCount = Math.max(longestCount, currentStreak);
        }

        return longestCount; 
    }
}
