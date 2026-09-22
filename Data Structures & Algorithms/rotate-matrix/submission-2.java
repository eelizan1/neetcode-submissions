class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
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
        int start = 0; 
        int end = row.length - 1; 

        while (start < end) {
            int temp = row[start]; 
            row[start] = row[end]; 
            row[end] = temp; 

            start++; 
            end--; 
        }
    }
}
