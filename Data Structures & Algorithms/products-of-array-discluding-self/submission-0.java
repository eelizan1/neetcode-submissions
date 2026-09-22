class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length]; 
        int[] prefix = new int[nums.length]; 
        int[] postfix = new int[nums.length]; 

        prefix[0] = 1; 
        postfix[postfix.length - 1] = 1; 

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1]; 
        }

        for (int i = prefix.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1]; 
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = prefix[i] * postfix[i]; 
        }

        return ans; 
    }
}  
