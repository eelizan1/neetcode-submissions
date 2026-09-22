class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>(); 
        int rows = board.length; 
        int cols = board[0].length; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') continue; 

                String rowKey = "row" + i + board[i][j]; 
                String colKey = "col" + j + board[i][j]; 
                String boxKey = "box" + (i/3) + (j/3) + board[i][j]; 

                if (set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) return false; 

                set.add(rowKey); 
                set.add(colKey); 
                set.add(boxKey);
            }
        }

        return true; 
    }
}
