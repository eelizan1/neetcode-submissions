class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.add(num);
        }

        // [5,4,3,2,1]

        for (int i = 0; i < k - 1; i++) {
            maxHeap.remove(); 
        }

        return maxHeap.peek(); 
    }
}
