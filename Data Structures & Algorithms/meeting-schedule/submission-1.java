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
        int[] start = new int[intervals.size()]; 
        int[] end = new int[intervals.size()]; 

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start; 
            end[i] = intervals.get(i).end; 
        }

        Arrays.sort(start); 
        Arrays.sort(end); 

        for (int i = 0; i < start.length - 1; i++) {
            if (end[i] > start[i + 1]) return false; 
        }

        return true; 
    }
}
