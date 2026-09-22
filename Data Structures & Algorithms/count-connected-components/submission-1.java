class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<>(); 
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        int count = 0; 

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] edge : edges) {
            int a = edge[0]; 
            int b = edge[1]; 

            graph.get(a).add(b); 
            graph.get(b).add(a); 
        }

        for (Integer node : graph.keySet()) {
            count += dfs(graph, node, visited); 
        }

        return count; 
    }

    private int dfs(HashMap<Integer, List<Integer>> graph, int node, HashSet<Integer> visited) {
        if (visited.contains(node)) return 0; 
        //if (graph.get(node) == null) return 0; 

        visited.add(node); 

        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited); 
        }

        return 1; 
    }
}
