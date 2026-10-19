class Solution {
    private List<Coord> DISTANCES = Arrays.asList(
        new Coord(1, 0), 
        new Coord(0, 1), 
        new Coord(-1, 0), 
        new Coord(0, -1)
    ); 

    public void islandsAndTreasure(int[][] grid) {
        Queue<Coord> q = new LinkedList<>(); 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Coord(i, j, 0)); 
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                Coord curr = q.remove(); 

                for (Coord neighbor : DISTANCES) {
                    int r = curr.row + neighbor.row; 
                    int c = curr.col + neighbor.col; 

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == -1 || grid[r][c] != Integer.MAX_VALUE) {
                        continue; 
                    }

                    Coord newCoord = new Coord(r, c, curr.distance + 1); 
                    q.add(newCoord); 

                    grid[r][c] = newCoord.distance; 
                }
            }
        }
    }
}

class Coord {
    int row; 
    int col; 
    int distance; 

    public Coord(int row, int col) {
        this.row = row; 
        this.col = col; 
    }

    public Coord(int row, int col, int distance) {
        this.row = row; 
        this.col = col; 
        this.distance = distance; 
    }
}
