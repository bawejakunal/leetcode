// https://leetcode.com/problems/minimum-time-difference

class Solution {
    
    private int absMinutes(String time) {
        String[] comp = time.split(":");
        int minutes = Integer.parseInt(comp[0]) * 60;
        minutes += Integer.parseInt(comp[1]);
        return minutes;
    }
    
    public int findMinDifference(List<String> timePoints) {
        boolean minutes[] = new boolean[1440];
        
        for (String time : timePoints) {
            int mint = absMinutes(time);
            if (minutes[mint])
                return 0;   // same timestamp
            minutes[mint] = true;
        }
        
        int minDif = Integer.MAX_VALUE;
        int prev = -1;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int t = 0; t < 1440; t++) {
            if (minutes[t]) {
                if (prev == -1)
                    first = t;
                else
                    minDif = Math.min(minDif, t - prev);
                prev = t;
                last = t;
            }
        }
        minDif = Math.min(minDif, 1440 - last + first);
        
        return minDif;
    }
}