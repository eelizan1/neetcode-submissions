class Solution {
    private static final List<int[]> DISTANCES = Arrays.asList(
        new int[] {1, 0}, 
        new int[] {-1, 0}, 
        new int[] {0, 1}, 
        new int[] {0, -1}
    );

    public int orangesRotting(int[][] grid) {
        int fresh = 0; 
        Queue<int[]> q = new LinkedList<>(); 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++; 
                }

                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j}); 
                }
            }
        }

        return bfs(grid, fresh, q); 
    }

    private int bfs(int[][] grid, int fresh, Queue<int[]> q) {
        int time = 0; 

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                int[] currCoord = q.remove();  

                for (int[] dist : DISTANCES) {
                    int r = currCoord[0] + dist[0]; 
                    int c = currCoord[1] + dist[1]; 

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != 1) continue; 
                        
                    grid[r][c] = 2; 
                    q.add(new int[] {r, c}); 
                    fresh--; 
                }      
            }

            time++; 
        }

        return fresh == 0 ? time : -1; 
    }
}
