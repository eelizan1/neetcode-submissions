class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target); 
        if (row == -1) return false; 

        return binarySearch(matrix[row], target); 
    }

    public int searchRow(int[][] matrix, int target) {
        int left = 0; 
        int right = matrix.length - 1; 

        while (left <= right) {
            int mid = (left + right) / 2; 
            int rowStart = matrix[mid][0]; 
            int rowEnd = matrix[mid][matrix[mid].length - 1];

            if (rowStart <= target && rowEnd >= target) {
                return mid; 
            } else if (rowStart > target) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return -1; 
    }

    public boolean binarySearch(int[] row, int target) {
        int left = 0; 
        int right = row.length - 1; 

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (row[mid] == target) {
                return true; 
            } else if (row[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return false; 
    }
}
