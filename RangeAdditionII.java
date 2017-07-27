// https://leetcode.com/problems/range-addition-ii/

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int []minArea = {m, n}; // min area pair
        for (int []pair: ops) {
            minArea[0] = Math.min(minArea[0], pair[0]);
            minArea[1] = Math.min(minArea[1], pair[1]);
        }
        return minArea[0]*minArea[1];
    }
}