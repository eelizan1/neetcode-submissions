class Solution {
    private List<Coord> DIRECTIONS = Arrays.asList(
        new Coord(1, 0), 
        new Coord(0, 1), 
        new Coord(-1, 0), 
        new Coord(0, -1)
    ); 

    public int orangesRotting(int[][] grid) {
        Queue<Coord> q = new LinkedList<>(); 
        int freshOranges = 0; 
        int time = 0; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++; 
                }

                if (grid[i][j] == 2) {
                    q.add(new Coord(i, j)); 
                }
            }
        }

        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                Coord coord = q.remove(); 

                for (Coord neighbor : DIRECTIONS) {
                    int r = coord.row + neighbor.row; 
                    int c = coord.col + neighbor.col;
                    Coord newCoord = new Coord(r, c); 

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != 1) continue; 

                    grid[r][c] = 2; 
                    q.add(newCoord); 
                    freshOranges--; 
                }
            }

            time++; 
        } 

        return freshOranges == 0 ? time : -1; 
    }
}

class Coord {
    int row; 
    int col; 

    Coord(int row, int col) {
        this.row = row; 
        this.col = col;
    }
}
