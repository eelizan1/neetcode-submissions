class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                    capture(i, j, board); 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O'; 
                }
            }
        }
    }

    private void capture(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') return;


        board[i][j] = 'T'; 

        capture(i + 1, j, board);
        capture(i, j + 1, board);
        capture(i - 1, j, board);
        capture(i, j - 1, board);
    }

    
}
