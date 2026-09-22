class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length; 
        int COLS = heights[0].length; 

        HashSet<List<Integer>> atlanticSet = new HashSet<>(); 
        HashSet<List<Integer>> pacificSet = new HashSet<>(); 

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacificSet, heights, Integer.MIN_VALUE); 
            dfs(r, COLS - 1, atlanticSet, heights, Integer.MIN_VALUE); 
        }

        for (int c = 0; c < COLS; c++) {
            // pacific - (first row, column position, set, previous height)
            dfs(0, c, pacificSet, heights, Integer.MIN_VALUE);    
            // atlantic - (last row, column position, set, previous height)
            dfs(ROWS - 1, c, atlanticSet, heights, Integer.MIN_VALUE); 
        }

        List<List<Integer>> result = new ArrayList<>(); 
        for (List<Integer> atlRowCol : atlanticSet) {
            if (pacificSet.contains(atlRowCol)) result.add(atlRowCol);
        }

        return result; 

    }

    private void dfs(int row, int col, HashSet<List<Integer>> visited, int[][] heights, int prevHeights) {
        List<Integer> rowCol = new ArrayList<>(); 
        rowCol.add(row); 
        rowCol.add(col); 

        if (visited.contains(rowCol)) return; 

        if (row < 0 || row == heights.length || col < 0 || col == heights[row].length || heights[row][col] < prevHeights) return; 

        visited.add(rowCol); 

        dfs(row + 1, col, visited, heights, heights[row][col]); 
        dfs(row - 1, col, visited, heights, heights[row][col]); 
        dfs(row, col + 1, visited, heights, heights[row][col]); 
        dfs(row, col - 1, visited, heights, heights[row][col]); 
    }
}
