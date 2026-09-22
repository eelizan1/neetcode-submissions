class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k]; 
        Map<Integer, Integer> map = new HashMap<>(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        // build map counts 
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        } 

        pq.addAll(map.keySet()); 

        for (int i = 0; i < k; i++) {
            result[i] = pq.remove(); 
        }

        return result; 
    }
}
