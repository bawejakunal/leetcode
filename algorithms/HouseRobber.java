// https://leetcode.com/problems/house-robber

public class Solution {
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int alterPrev = prevYes;
            prevYes = Math.max(prevNo, prevYes);
            prevNo = n + alterPrev;
        }
        return Math.max(prevNo, prevYes);
    }
}