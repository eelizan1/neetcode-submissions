class Solution {
    public int leastInterval(char[] tasks, int n) {
        // each task takes 1 unit time
        // minimize idle time

        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : tasks) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(count.values());

        int time = 0;
        Queue<int[]> q = new LinkedList<>(); // pairs of [cnt, idleTime]

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[] { cnt, time + n });
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}