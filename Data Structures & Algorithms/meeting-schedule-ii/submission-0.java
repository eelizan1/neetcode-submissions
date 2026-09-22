/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int[intervals.size()]; 
        int[] ends = new int[intervals.size()]; 

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start; 
            ends[i] = intervals.get(i).end; 
        }

        Arrays.sort(starts); 
        Arrays.sort(ends); 

        int max = 0; 
        int curr = 0; 
        int start = 0; 
        int end = 0; 

        while (start < intervals.size()) {
            if (starts[start] < ends[end]) {
                curr++; 
                start++; 
            } else {
                curr--; 
                end++; 
            }

            max = Math.max(max, curr); 
        }

        return max; 
    }
}
