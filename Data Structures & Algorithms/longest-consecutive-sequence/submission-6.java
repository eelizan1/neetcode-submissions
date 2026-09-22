class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0; 
        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) {
            set.add(num); 
        }

        for (int num : nums) {
            int currStreak = 1; 

            int numCopy = num; 
            while (set.contains(numCopy + 1)) {
                currStreak++; 
                numCopy++; 
            }

            max = Math.max(max, currStreak); 
        }

        return max; 
    }
}
