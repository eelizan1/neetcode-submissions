class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length]; 
        int[] left = new int[nums.length]; 
        int[] right = new int[nums.length]; 

        left[0] = 1; 
        right[right.length - 1] = 1; 

        // build left 
        for (int i = 1; i < left.length; i++) {
            left[i] = nums[i-1] * left[i-1]; 
        }

        // build right 
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1]; 
        }

        // build result 
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res; 
    }
}  
