class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); 

        for (int num : nums) {
            heap.add(num); 
        }

        int count = 0; 
        while (count < k - 1) {
            heap.remove(); 
            count++; 
        }

        return heap.remove(); 
    }
}

// [2,3,1,5,4]
// [5, 4, 3, 2, 1]
// 