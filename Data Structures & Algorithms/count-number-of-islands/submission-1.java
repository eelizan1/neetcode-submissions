class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j); 
                    islands++; 
                }
            }
        }

        return islands; 
    }

    private void dfs(char[][] grid, int i, int j) {
        // check for out of bounds 
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return; 
        }

        grid[i][j] = '0'; 

        dfs(grid, i + 1, j); 
        dfs(grid, i - 1, j); 
        dfs(grid, i, j + 1); 
        dfs(grid, i, j - 1); 
    }
}
