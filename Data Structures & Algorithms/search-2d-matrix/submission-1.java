class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; 
        int cols = matrix[0].length; 

        int leftRow = 0; 
        int rightRow = rows - 1; 

        while (leftRow <= rightRow) {
            int middleRow = leftRow + (rightRow - leftRow) / 2;


            if (target > matrix[middleRow][cols - 1]) {
                leftRow = middleRow + 1;
            } else if (target < matrix[middleRow][0]) {
                rightRow = middleRow - 1;
            }
            else {
                break; 
            }
        }

        int row = (leftRow + rightRow) / 2; 
        int left = 0; 
        int right = cols - 1; 

        while (left <= right) {
            int middle = (left + right) / 2; 
            if (matrix[row][middle] < target) {
                left = middle + 1; 
            } else if (matrix[row][middle] > target) {
                right = middle - 1; 
            } else {
                return true;
            }
        }

        return false; 
    }
}
