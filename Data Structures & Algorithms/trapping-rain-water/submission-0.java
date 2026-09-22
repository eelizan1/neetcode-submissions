class Solution {
    public int trap(int[] height) {
        int maxLeft = Integer.MIN_VALUE; 
        int maxRight = Integer.MIN_VALUE; 
        int[] maxLeftArray = new int[height.length]; 
        int[] maxRightArray = new int[height.length]; 
        int[] minArray = new int[height.length]; 
        int volume = 0; 

        // build max left array 
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]); 
            maxLeftArray[i] = maxLeft;
        }

        // build max right array 
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]); 
            maxRightArray[i] = maxRight; 
        }

        // build volume array 
        for (int i = 0; i < minArray.length; i++) {
            minArray[i] = Math.min(maxLeftArray[i], maxRightArray[i]); 
        }

        for (int i = 0; i < minArray.length; i++) {
            int currVolume = minArray[i] - height[i]; 
            if (currVolume < 0) currVolume = 0; 

            volume += currVolume; 
        }

        return volume; 
    }
}
