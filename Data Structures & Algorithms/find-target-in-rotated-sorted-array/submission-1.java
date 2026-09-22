class Solution {
    public int search(int[] nums, int target) {
        int pivotPoint = findMin(nums); 
        int leftSearch = binarySearch(nums, 0, pivotPoint - 1, target); 
        if (leftSearch != -1) return leftSearch; 

        return binarySearch(nums, pivotPoint, nums.length - 1, target); 
    }

    private int findMin(int[] nums) {
        int left = 0; 
        int right = nums.length -1; 

        while (left < right) {
            int mid = (left + right) / 2; 

            if (nums[mid] > nums[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        return left; 
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start; 
        int right = end; 

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                left = mid + 1; 
            } else if (nums[mid] > target) {
                right = mid - 1; 
            }
        }

        return -1; 
    }
}
