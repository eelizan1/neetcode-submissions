class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 

        while (left < right) {
            int mid = (left + right) / 2; 

            if (nums[mid] > nums[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        int pivot = left; 

        int leftHalfResult = binarySearch(nums, target, 0, pivot - 1); 
        if (leftHalfResult != -1) return leftHalfResult; 

        int rightHalfResult = binarySearch(nums, target, pivot, nums.length - 1); 
        if (rightHalfResult != -1) return rightHalfResult; 

        return -1; 
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2; 

            if (nums[mid] < target) {
                left = mid + 1; 
            } else if (nums[mid] > target) {
                right = mid - 1; 
            } else {
                return mid; 
            }
        }

        return -1; 
    }
}
