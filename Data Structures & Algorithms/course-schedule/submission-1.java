class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites); 
        Set<Integer> visiting = new HashSet<>(); 
        Set<Integer> visited = new HashSet<>(); 

        for (int key : graph.keySet()) {
            if (hasCycle(key, graph, visiting, visited)) return false; 
        }

        return true; 
    }

    public boolean hasCycle(int node, HashMap<Integer, List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(node)) return true; 
        if (visited.contains(node)) return false; 

        visiting.add(node); 
        
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visiting, visited)) return true; 
        }

        visiting.remove(node); 
        visited.add(node); 
        return false; 
    }

    public HashMap<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] prereq : prerequisites) {
            int courseA = prereq[0]; 
            int courseB = prereq[1]; 

            graph.get(courseB).add(courseA); 
        }

        return graph; 
    }
}
