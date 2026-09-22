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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int[] starts = new int[intervals.size()]; 
        int[] ends = new int[intervals.size()]; 

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start; 
            ends[i] = intervals.get(i).end; 
        }

        Arrays.sort(starts); 
        Arrays.sort(ends); 

        for (int i = 0; i < starts.length - 1; i++) {
            if (starts[i + 1] < ends[i]) return false; 
        }

        return true; 
    }
}
