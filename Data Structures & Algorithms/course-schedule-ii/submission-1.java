class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>(); 
        Set<Integer> visiting = new HashSet<>(); 
        Set<Integer> visited = new HashSet<>(); 
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites); 

        for (int key : graph.keySet()) {
            if (hasCycle(key, list, visiting, visited, graph)) return new int[] {}; 
        }

        int[] res = new int[list.size()]; 
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i); 
        }

        return res; 
    }

    private boolean hasCycle(int node, List<Integer> list, Set<Integer> visiting, Set<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        if (visiting.contains(node)) return true; 
        if (visited.contains(node)) return false; 

        visiting.add(node); 

        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, list, visiting, visited, graph)) return true; 
        }

        visiting.remove(node); 
        visited.add(node); 
        list.add(node); 

        return false; 
    }

    private HashMap<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] courses : prerequisites) {
            int courseA = courses[0]; 
            int courseB = courses[1]; 

            graph.get(courseA).add(courseB);
        }

        return graph; 
    }
}
