class Solution {
    public boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>(); 

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, visited)) return true; 
                }
            }
        }

        return false; 
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, Set<String> visited) {
        if (index == word.length()) return true; 

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) return false; 
        
        String key = i + "," + j; 
        if (visited.contains(key)) return false;

        visited.add(key); 

        boolean up = dfs(board, i + 1, j, word, index + 1, visited); 
        boolean down = dfs(board, i - 1, j, word, index + 1, visited); 
        boolean right = dfs(board, i, j + 1, word, index + 1, visited); 
        boolean left = dfs(board, i, j - 1, word, index + 1, visited); 

        visited.remove(key); 

        return up || down || right || left; 
    }
}
