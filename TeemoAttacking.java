// https://leetcode.com/problems/teemo-attacking/description/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        int currentEnd = 0;
        int prevEnd = 0;
        
        for (int time: timeSeries) {
            currentEnd = time + duration;     // expected end of current attack
            totalDuration += currentEnd - Math.max(time, prevEnd);
            prevEnd = currentEnd;            // for next iteration
        }
        
        return totalDuration;
    }
}