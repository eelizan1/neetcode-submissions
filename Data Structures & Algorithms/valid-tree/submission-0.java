class Solution {
    public boolean validTree(int n, int[][] edges) {
        // check for any disconnected components 
        if (edges.length > n - 1) return false; 

        // build adj graph 
        Map<Integer, List<Integer>> adj = buildGraph(n, edges); 
        Set<Integer> visit = new HashSet<>(); 

        if (hasCycle(0, -1, visit, adj)) return false; 

        return visit.size() == n; 
    }

    private boolean hasCycle(int node, int parent, Set<Integer> visit, Map<Integer, List<Integer>> graph) {
        if (visit.contains(node)) return true; 

        visit.add(node); 

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue; 

            if (hasCycle(neighbor, node, visit, graph)) return true; 
        }

        return false; 
    }

    private HashMap<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] edge : edges) {
            int edgeA = edge[0]; 
            int edgeB = edge[1]; 

            graph.get(edgeA).add(edgeB); 
            graph.get(edgeB).add(edgeA); 
        }

        return graph; 
    }
}
