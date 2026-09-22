class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>(); 
        Set<Integer> visiting = new HashSet<>(); 
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites); 

        for (int key : graph.keySet()) {
            if (hasCycle(key, graph, visited, visiting)) return false; 
        }

        return true; 
    }

    private boolean hasCycle(int node, HashMap<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> visiting) {
        if (visiting.contains(node)) return true; 

        if (visited.contains(node)) return false; 

        visiting.add(node); 

        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visited, visiting)) return true; 
        }

        visiting.remove(node); 
        visited.add(node); 

        return false; 
    }

    private HashMap<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] course : prerequisites) {
            int courseA = course[0]; 
            int courseB = course[1]; 

            graph.get(courseA).add(courseB); 
        }

        return graph; 
    }
}
