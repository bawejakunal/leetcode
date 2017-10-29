// https://leetcode.com/problems/merge-intervals/description/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new LinkedList<Interval>();
        if (intervals == null || intervals.size() < 1)
            return merged;

        // sort intervals
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start)
                    return a.end - b.end;
                return a.start - b.start;
            }
        });
        
        
        for (Interval n: intervals) {
            if (merged.size() < 1) {
                merged.add(n);
            }
            else {
                Interval last = merged.get(merged.size() - 1);
                if (last.end >= n.start)
                    last.end = Math.max(n.end, last.end);
                else{
                    merged.add(n);
                }
            }
        }
        return merged;
    }
}