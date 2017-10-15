// https://leetcode.com/problems/exclusive-time-of-functions/description/

// Functions are called only by other functions or recursively, hence
// balanced parenthesis like start, end pairs can be seen

public class Solution {
    public int[] exclusiveTime(int n, List < String > logs) {
        
        // function stack
        Stack < Integer > stack = new Stack < > ();
        int[] time = new int[n];
        
        String[] log = logs.get(0).split(":");
        stack.push(Integer.parseInt(log[0]));
        int prev = Integer.parseInt(log[2]);
        
        for (int i = 1; i < logs.size(); i++) {
            // next log
            log = logs.get(i).split(":");
            if (log[1].equals("start")) {
                if (!stack.isEmpty()){
                    time[stack.peek()] += Integer.parseInt(log[2]) - prev; // very beginning of time
                }
                stack.push(Integer.parseInt(log[0]));
                prev = Integer.parseInt(log[2]);    // update previous log record timestamp
            } else {
                time[stack.peek()] += Integer.parseInt(log[2]) - prev + 1; // very end of time
                stack.pop();            // function call ends, remove from stack
                prev = Integer.parseInt(log[2]) + 1;
            }
        }
        return time;
    }
}