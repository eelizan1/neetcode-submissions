class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length; i++) {
            int p1 = i + 1; 
            int p2 = nums.length - 1; 

            // i duplciate check 
            if (i > 0 && nums[i] == nums[i - 1]) continue; 

            while (p1 < p2) {
                int currSum = nums[i] + nums[p1] + nums[p2]; 

                if (currSum == 0) {
                    List<Integer> currResult = new ArrayList<>();
                    currResult.add(nums[i]); 
                    currResult.add(nums[p1]); 
                    currResult.add(nums[p2]); 

                    result.add(currResult); 

                    // duplciate checks 
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++; 
                    while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--; 

                    p1++; 
                    p2--; 
                } else if (currSum < 0) {
                    p1++; 
                } else {
                    p2--; 
                }
            }
        }

        return result; 
    }
}
