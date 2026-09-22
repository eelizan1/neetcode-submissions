class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        HashSet<Integer> visiting = new HashSet<>(); 
        HashSet<Integer> visited = new HashSet<>(); 

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] prereq : prerequisites) {
            int a = prereq[0]; 
            int b = prereq[1]; 

            graph.get(a).add(b); 
        }

        for (int course : graph.keySet()) {
            if (hasCycle(graph, course, visiting, visited)) return false; 
        }

        return true; 
    }

    public boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(course)) return true; 
        if (visited.contains(course)) return false; 

        visiting.add(course); 

        for (int neighbor : graph.get(course)) {
            if(hasCycle(graph, neighbor, visiting, visited)) return true; 
        }

        visited.contains(course); 
        visiting.remove(course); 

        return false; 
    }
}
