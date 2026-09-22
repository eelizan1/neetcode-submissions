class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE; 
        int p1 = 0; 
        int p2 = heights.length - 1; 

        while (p1 < p2) {
            int length = p2 - p1; 
            int height = Math.min(heights[p1], heights[p2]); 
            int currArea = length * height; 

            max = Math.max(max, currArea); 

            if (heights[p1] < heights[p2]) {
                p1++; 
            } else {
                p2--; 
            }
        }

        return max; 
    }
}
