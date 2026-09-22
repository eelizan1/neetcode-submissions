class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites); 
        List<Integer> courses = new ArrayList<>(); 
        Set<Integer> visiting = new HashSet<>(); 
        Set<Integer> visited = new HashSet<>(); 

        for (int key : graph.keySet()) {
            if (hasCycle(key, graph, visiting, visited, courses)) {
                return new int[] {}; 
            }
        }

        int[] result = new int[courses.size()]; 
        for (int i = 0; i < courses.size(); i++) {
            result[i] = courses.get(i); 
        }

        return result; 
    }

    private boolean hasCycle(int course, HashMap<Integer, List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited, List<Integer> courses) {
        if (visiting.contains(course)) return true; 
        if (visited.contains(course)) return false; 
        
        visiting.add(course); 

        for (int neighbor : graph.get(course)) {
            if (hasCycle(neighbor, graph, visiting, visited, courses)) return true; 
        }

        visited.add(course); 
        visiting.remove(course); 
        courses.add(course); 

        return false; 
    }

    private HashMap<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        for (int[] prereq : prerequisites) {
            int a = prereq[0]; 
            int b = prereq[1]; 

            graph.get(a).add(b);
        }

        return graph; 
    }
}
