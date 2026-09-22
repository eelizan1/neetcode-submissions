class Solution {
    private List<Coord> DIRECTIONS = Arrays.asList(
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
                Coord coord = q.remove(); 

                for (Coord neighborCoord : DIRECTIONS) {
                    int r = coord.row + neighborCoord.row; 
                    int c = coord.col + neighborCoord.col; 

                    Coord neighbor = new Coord(r, c, coord.distance + 1); 

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != Integer.MAX_VALUE) continue; 

                    q.add(neighbor); 
                    grid[r][c] = neighbor.distance; 
                }
            }
        }
    }
}

class Coord {
    int row; 
    int col;
    int distance;

    Coord(int row, int col) {
        this.row = row; 
        this.col = col; 
    }

    Coord(int row, int col, int distance) {
        this.row = row; 
        this.col = col; 
        this.distance = distance; 
    }
}
