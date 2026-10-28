class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>(); 
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1; 
            int right = nums.length - 1; 

            // duplicate check if i pointer 
            if (i > 0 && nums[i] == nums[i-1]) continue; 

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right]; 

                if (currSum == 0) {
                    List<Integer> curr = new ArrayList<>(); 
                    curr.add(nums[i]); 
                    curr.add(nums[left]); 
                    curr.add(nums[right]);
                    result.add(curr); 

                    // dup check 
                    while (left < right && nums[left] == nums[left + 1]) left++; 
                    while (left < right && nums[right] == nums[right - 1]) right--; 

                    left++; 
                    right--;  

                } else if (currSum < 0) {
                    left++;

                } else if (currSum > 0) {
                    right--;
                }
            }
        }

        return result; 
    }
}
