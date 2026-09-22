class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = Integer.MIN_VALUE; 

        for (int num : piles) {
            high = Math.max(high, num); 
        }

        while (low <= high) {
            int mid = (low + high) / 2; 
            int time = getTimeToEatAllBananas(piles, mid); 

            if (time <= h) {
                high = mid - 1; 
            } else if (time > h) {
                low = mid + 1; 
            }
        }

        return low; 
    }

    private int getTimeToEatAllBananas(int[] piles, int rate) {
        int h = 0; 
        for (int pile : piles) {
            h += Math.ceil((double) pile / rate); 
        }

        return h; 
    }
}
