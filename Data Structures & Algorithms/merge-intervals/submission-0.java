class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList(); 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        merged.add(intervals[0]); 

        for (int[] interval : intervals) {
            int[] lastInterval = merged.get(merged.size() - 1); 

            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]); 
            } else {
                merged.add(interval); 
            }
        }

        int[][] res = new int[merged.size()][2]; 
        for (int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i); 
        }

        return res; 
    }
}
