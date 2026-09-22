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
            reverseRow(row); 
        }
    }

    private void reverseRow(int[] row) {
        int p1 = 0; 
        int p2 = row.length - 1; 

        while (p1 < p2) {
            int temp = row[p1]; 
            row[p1] = row[p2]; 
            row[p2] = temp; 

            p1++; 
            p2--; 
        }
    }
}
