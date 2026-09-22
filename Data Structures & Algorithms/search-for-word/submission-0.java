class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, visited)) return true; 
                }
            }
        }

        return false; 
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true; 
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j] || visited[i][j] == true) {
            return false; 
        }

        visited[i][j] = true; 
        index++; 

        boolean right = dfs(board, i + 1, j, word, index, visited); 
        boolean left = dfs(board, i - 1, j, word, index, visited); 
        boolean up = dfs(board, i, j + 1, word, index, visited); 
        boolean down = dfs(board, i, j - 1, word, index, visited); 

        visited[i][j] = false; 

        return right || left || up || down;
    }
}
