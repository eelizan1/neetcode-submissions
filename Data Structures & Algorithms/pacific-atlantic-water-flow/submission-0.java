class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1},  {0, -1}}; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length; 
        int COLS = heights[0].length;

        boolean[][] pacificReachable = new boolean[ROWS][COLS];
        boolean[][] atlanticReachable = new boolean[ROWS][COLS]; 

        Queue<int[]> pacificQueue = new LinkedList<>(); 
        Queue<int[]> atlanticQueue = new LinkedList<>(); 

        for (int c = 0; c < COLS; c++) {
            pacificQueue.offer(new int[]{0, c}); 
            atlanticQueue.offer(new int[]{ROWS - 1, c}); 
        }

        for (int r = 0; r < ROWS; r++) {
            pacificQueue.offer(new int[]{r, 0}); 
            atlanticQueue.offer(new int[]{r, COLS - 1}); 
        }

        bfs(heights, pacificQueue, pacificReachable); 
        bfs(heights, atlanticQueue, atlanticReachable); 

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable) {
        int ROWS = heights.length; 
        int COLS = heights[0].length; 

        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); 
            int row = cell[0]; 
            int col = cell[1]; 

            reachable[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0]; 
                int newCol = col + dir[1]; 

                if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS) continue; 
                if (reachable[newRow][newCol]) continue; 
                if (heights[newRow][newCol] < heights[row][col]) continue; 

                queue.offer(new int[] {newRow, newCol});

            }
        }
    }
}
