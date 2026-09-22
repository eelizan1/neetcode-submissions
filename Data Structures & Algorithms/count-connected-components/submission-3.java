class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<>(); 
        HashMap<Integer, List<Integer>> graph = buildGraph(n, edges); 
        int count = 0; 

        for (int node : graph.keySet()) {
            count += dfs(node, visited, graph); 
        }

        return count; 
    }

    private int dfs(int node, HashSet<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        if (visited.contains(node)) return 0; 

        visited.add(node); 

        for (int neighbor : graph.get(node)) {
            dfs(neighbor, visited, graph); 
        }

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
