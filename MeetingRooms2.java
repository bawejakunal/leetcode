// https://leetcode.com/problems/meeting-rooms-ii/

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
    public int minMeetingRooms(Interval[] intervals) {
        
        if (intervals == null || intervals.length == 0)
            return 0;
        
        // ascending sort on start times
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        
        // min heap on end times
        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        // heap size = number of rooms
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval earliest = heap.poll();
            if (intervals[i].start >= earliest.end) {
                earliest.end = intervals[i].end;  // merge meetings possible in the same room
            }
            else {
                heap.add(intervals[i]);
            }
            heap.offer(earliest);
        }
        
        return heap.size();
    }
}