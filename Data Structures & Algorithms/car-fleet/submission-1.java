class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store each car as [position, speed]
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position in descending order.
        // This lets us process the car closest to the target first.
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;

        // The time it takes for the fleet ahead to reach the target.
        // Starts at 0 because no fleets exist yet.
        double currentFleetTime = 0;

        // Process cars from closest to the target to farthest.
        for (int[] car : cars) {

            // Time for this car to reach the target if it drove alone.
            double time = (double) (target - car[0]) / car[1];

            // If this car takes LONGER than the fleet ahead,
            // it cannot catch up, so it forms a new fleet.
            if (time > currentFleetTime) {
                fleets++;

                // This new fleet's arrival time becomes the one
                // that cars behind must compare against.
                currentFleetTime = time;
            }

            // Otherwise (time <= currentFleetTime),
            // this car catches the fleet ahead before the target,
            // so it joins that fleet.
        }

        return fleets;
    }
}