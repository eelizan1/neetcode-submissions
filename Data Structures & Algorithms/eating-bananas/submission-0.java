class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = Integer.MIN_VALUE; 

        for (int pile : piles) {
            right = Math.max(right, pile); 
        }

        while (left <= right) {
            int mid = (left + right) / 2; 
            int time = timeToEatAllBananas(piles, mid); 

            if (time <= h) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return left; 
    }

    private int timeToEatAllBananas(int[] piles, int rate) {
        int h = 0; 
        for (int pile : piles) {
            h += Math.ceil((double) pile / rate); 
        }

        return h; 
    }
}
