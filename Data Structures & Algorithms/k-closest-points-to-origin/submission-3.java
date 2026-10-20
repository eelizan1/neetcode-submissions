class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // k rows of two cols each 
        int[][] res = new int[k][2]; 
        // min heap 
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance); 

        // go through each point 
        for (int[] point : points) {
            int x = point[0]; 
            int y = point[1]; 
            int distance = getDistance(x, y); 
            Point p = new Point(x, y, distance);

            pq.add(p); 
        }

        for (int i = 0; i < k; i++) {
            Point p = pq.remove(); 
            int[] coord = {p.x, p.y}; 
            res[i] = coord; 
        }

        return res; 
    }

    private int getDistance(int x, int y) {
        return x * x + y * y;   // no sqrt needed, no precision loss
    }
}

class Point {
    int x; 
    int y; 
    int distance; 

    public Point (int x, int y, int distance) {
        this.x = x; 
        this.y = y; 
        this.distance = distance; 
    }
}
