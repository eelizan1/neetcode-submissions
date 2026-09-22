class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = temp; 
            }
        }

        for (int[] row : matrix) {
            reverse(row); 
        }
    }

    private void reverse(int[] row) {
        int left = 0; 
        int right = row.length -1; 

        while (left < right) {
            int temp = row[left]; 
            row[left] = row[right]; 
            row[right] = temp; 

            left++; 
            right--; 
        }
    }
}
