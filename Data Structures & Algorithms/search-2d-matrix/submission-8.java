class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length; 
        int COLS = matrix[0].length; 

        int topRow = 0; 
        int bottomRow = ROWS - 1; 

        while (topRow <= bottomRow) {
            int middleRow = (topRow + bottomRow) / 2; 

            if (target > matrix[middleRow][COLS - 1]) {
                topRow = middleRow + 1; 
            } else if (target < matrix[middleRow][0]) {
                bottomRow = middleRow - 1; 
            } else {
                break; 
            }
        }

        int row = (topRow + bottomRow) / 2; 
        int left = 0; 
        int right = COLS - 1; 

        while (left <= right) {
            int middle = (left + right) / 2; 

            if (target > matrix[row][middle]) {
                left = middle + 1; 
            } else if (target < matrix[row][middle]) {
                right = middle - 1; 
            } else {
                return true; 
            }
        }

        return false; 
    }
}
