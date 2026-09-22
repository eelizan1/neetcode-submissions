class Solution {

    // Represents a task that has been run and is now waiting out its cooldown
    // before it can be run again.
    private static class CooldownTask {
        int count;      // how many occurrences of this task still remain to be run
        int readyTime;  // the time at which this task becomes available again

        CooldownTask(int count, int readyTime) {
            this.count = count;
            this.readyTime = readyTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        // Each task takes 1 unit of time to run.
        // Goal: minimize total time (including any unavoidable idle slots),
        // given that the same task must wait at least `n` slots before repeating.

        // Step 1: Count how many times each task occurs.
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Put all counts into a max-heap.
        // The heap always gives us the task with the most remaining
        // occurrences — greedily running the busiest task first is what
        // keeps idle time to a minimum.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(countMap.values());

        int time = 0; // tracks the current time slot / tick

        // Step 3: Queue of tasks currently "resting" on cooldown.
        // FIFO order works because tasks are added in the order their
        // cooldowns start, so the front of the queue always has the
        // earliest readyTime.
        Queue<CooldownTask> cooldownQueue = new LinkedList<>();

        // Keep going as long as there's a task either ready to run
        // (in maxHeap) or waiting to become ready (in cooldownQueue).
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++; // advance the clock by one slot

            // If a task is available right now, run the most frequent one.
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1; // "run" it: one fewer occurrence left

                // If it still has occurrences left, send it to cooldown.
                // It'll become available again after `n` slots pass.
                if (remaining > 0) {
                    cooldownQueue.add(new CooldownTask(remaining, time + n));
                }
            }
            // If maxHeap was empty, this tick is an idle slot — nothing to run.

            // Check whether the task at the front of the cooldown queue
            // has finished waiting. If so, move it back into the heap
            // so it can be considered for running again.
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().readyTime == time) {
                maxHeap.add(cooldownQueue.poll().count);
            }
        }

        // Total ticks elapsed = minimum time needed to run all tasks.
        return time;
    }
}