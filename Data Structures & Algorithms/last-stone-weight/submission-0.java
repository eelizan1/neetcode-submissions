class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        
        for (int stone : stones) {
            maxHeap.add(stone); 
        }

        while (maxHeap.size() > 1) {
            int largest = maxHeap.remove(); 
            int nextLargest = maxHeap.remove(); 

            if (largest != nextLargest) {
                maxHeap.add(largest - nextLargest); 
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove(); 
    }
}
