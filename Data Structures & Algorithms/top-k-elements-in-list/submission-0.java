class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        int[] res = new int[k]; 

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        maxHeap.addAll(map.keySet()); 

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll(); 
        }

        return res; 
    }
}
