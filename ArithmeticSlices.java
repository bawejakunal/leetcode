// https://leetcode.com/problems/arithmetic-slices

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int seq = 0;
        for (int strt = 1; strt < A.length - 1;) {
            int diff = A[strt] - A[strt - 1];   // seq diff
            int wdth = 1;
            strt++;
            while (strt < A.length && diff == A[strt] - A[strt-1]) {
                wdth++;
                strt++;
            }
            if (wdth > 1) {
                int t = wdth - 1;
                seq += (t*(t+1))/2;
            }
        }
        return seq;
    }
}