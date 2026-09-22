class Solution {
    public int longestConsecutive(int[] nums) {
        int maxStreak = 0; 
        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) {
            set.add(num); 
        }

        for (int num : nums) {
            if (set.contains(num - 1)) continue; 

            int currStreak = 1; 
            int currNum = num; 
            while (set.contains(currNum + 1)) {
                currStreak++; 
                currNum++; 
            }

            maxStreak = Math.max(maxStreak, currStreak); 
        }

        return maxStreak; 
    }
}
