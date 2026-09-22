class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = 0; 

        for (int pile : piles) high = Math.max(high, pile);

        while (low <= high) {
            int mid = (low + high) / 2; 
            int time = getTimeToEatAllBananas(mid, piles); 

            if (time <= h) {
                high = mid - 1; 
            } else if (time > h) {
                low = mid + 1; 
            }
        }

        return low; 
    }

    private int getTimeToEatAllBananas(int mid, int[] piles) {
        int rate = 0; 
        for (int pile : piles) {
            rate += Math.ceil((double)pile / mid); 
        }

        return rate; 
    }
}
