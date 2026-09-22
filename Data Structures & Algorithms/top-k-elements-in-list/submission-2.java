class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k]; 
        Map<Integer, Integer> map = new HashMap<>(); 
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); 

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        }

        for (int n : map.keySet()) {
            heap.add(n); 
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.remove(); 
        }

        return res; 
    }
}
