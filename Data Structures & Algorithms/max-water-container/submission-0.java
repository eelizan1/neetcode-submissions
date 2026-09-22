class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE; 
        int start = 0; 
        int end = heights.length - 1; 

        while (start < end) {
            int length = end - start; 
            int height = Math.min(heights[start], heights[end]); 
            int currArea = length * height; 
            maxArea = Math.max(maxArea, currArea); 

            if (heights[start] < heights[end]) {
                start++; 
            } else {
                end--; 
            }
        }

        return maxArea; 
    }
}
