class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1; 

        if (m == 0 || n == 0) return 0; 

        return uniquePaths(n - 1, m) + uniquePaths(n, m - 1); 
    }
}
