class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums); 

        // outer 3rd pointer 
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1; 
            int right = nums.length - 1; 

            if (i > 0 && nums[i] == nums[i - 1]) continue; 

            // innter two pointer 
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right]; 

                if (currentSum == 0) {
                    List<Integer> list = new ArrayList<>(); 
                    list.add(nums[i]); 
                    list.add(nums[left]); 
                    list.add(nums[right]); 

                    res.add(list); 

                    while (left < right && nums[left] == nums[left + 1]) left++; 
                    while (left < right && nums[right] == nums[right - 1]) right--;     

                    left++; 
                    right--; 
                } else if (currentSum < 0) {
                    left++; 
                } else {
                    right--; 
                }
            }
        }

        return res; 
    }
}
