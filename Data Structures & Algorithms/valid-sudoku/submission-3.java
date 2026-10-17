class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>(); 

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue; 

                String rowKey = "row" + i + board[i][j]; // row05
                String colKey = "col" + j + board[i][j]; // col05 
                String boxKey = "subBox" + (i/3) + (j/3) + board[i][j]; 

                if (set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) return false; 

                set.add(rowKey); 
                set.add(colKey); 
                set.add(boxKey); 
            }
        }

        return true; 
    }
}
