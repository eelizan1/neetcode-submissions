class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2]; 

        UnionFind unionFind = new UnionFind(edges.length); 

        for (int[] edge : edges) {
            int a = edge[0]; 
            int b = edge[1]; 

            if (unionFind.find(a) == unionFind.find(b)) return edge; 

            unionFind.union(a, b); 
        }

        return res; 
    }
}

class UnionFind {
    private int[] bijection; 

    public UnionFind(int n) {
        bijection = new int[n + 1]; 
        for (int i = 0; i <= n; i++) {
            bijection[i] = i; 
        }
    }

    public int find(int node) {
        while (bijection[node] != node) {
            node = bijection[node]; 
        }

        return node; 
    }

    public void union(int a, int b) {
        int parentA = find(a); 
        int parentB = find(b); 

        if (parentA != parentB) {
            bijection[parentB] = parentA; 
        }
    }
}