class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = buildGraph(n, edges); 
        Set<Integer> visited = new HashSet<Integer>(); 
        int count = 0; 

        for (int key : graph.keySet()) {
            count += dfs(graph, key, visited); 
        }

        return count; 
    }

    private int dfs(HashMap<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return 0; 

        visited.add(node); 

        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited); 
        }

        //visited.remove(node); 

        return 1; 
    }

    private HashMap<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] edge : edges) {
            int a = edge[0]; 
            int b = edge[1]; 

            graph.get(a).add(b); 
            graph.get(b).add(a); 
        }

        return graph; 
    }
}
