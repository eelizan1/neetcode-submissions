class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0; 
        int p2 = numbers.length - 1; 

        while(p1 < p2) {
            int currentSum = numbers[p1] + numbers[p2]; 
            if (currentSum == target) {
                return new int[] {p1 + 1, p2 + 1}; 
            } else if (currentSum < target) {
                p1++; 
            } else {
                p2--; 
            }
        }

        return new int[] {-1, -1}; 
    }
}
