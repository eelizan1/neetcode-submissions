class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length; 
        int COLS = matrix[0].length; 

        // 1. look for the row that we need to find 
       int topRow = 0; 
       int bottomRow = ROWS - 1; 

       while (topRow <= bottomRow) {
           int middleRow = (topRow + bottomRow) / 2; 

					 // see if current row contains target 
           if (target > matrix[middleRow][COLS - 1]) { // compare target with current row's right most element 
               // look at rows with larger values 
               topRow = middleRow + 1; 
           } else if (target < matrix[middleRow][0]) { // compare target with current row's left most element 
               // look at rows with smaller values 
               bottomRow = middleRow - 1; 
           } else {
               break; // target falls within this row and do second binary search on the row 
           }
       }

       // 2. search the row 
       int row = (topRow + bottomRow) / 2; // use the top and bottom pointers to get the row 
       int left = 0; // left most position in the row 
       int right = COLS - 1; // right most position in the row 

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