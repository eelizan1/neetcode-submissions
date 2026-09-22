class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); 
        int maxStreak = 0; 

        for (int num : nums) {
            set.add(num); 
        }

        for (int i = 0; i < nums.length; i++) {
            int currStreak = 1; 

            int j = nums[i]; 
            while (set.contains(j + 1)) {
                currStreak++; 
                j++; 
            }

            maxStreak = Math.max(maxStreak, currStreak); 
        }

        return maxStreak; 
    }
}

// [2,20,4,10,3,4,5]
// {2,20,10,3,4,5}

// maxStreak = -INF
