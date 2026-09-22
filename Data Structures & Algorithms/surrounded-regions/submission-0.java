class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1)) {
                    dfs(i, j, board); 
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O'; 
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') return; 

        board[i][j] = 'T'; 

        dfs(i + 1, j, board); 
        dfs(i - 1, j, board); 
        dfs(i, j + 1, board); 
        dfs(i, j - 1, board); 
    }
}
