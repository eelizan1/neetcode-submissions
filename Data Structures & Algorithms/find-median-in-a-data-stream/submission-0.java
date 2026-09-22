class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (minHeap.size() == 0 || num < minHeap.peek()) {
            maxHeap.add(num); 
        } else {
            minHeap.add(num); 
        }

        balanceHeaps(); 
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; 
        }

        return maxHeap.peek(); 
    }

    private void balanceHeaps() {
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove()); 
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove()); 
        }
    }
}
