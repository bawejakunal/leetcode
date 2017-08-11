// https://leetcode.com/problems/counting-bits

public class Solution {
    public int[] countBits(int num) {
        int bits[] = new int[num+1];
        for (int n = 1; n <= num; n++) {
            if ((n & (n-1)) == 0)         // power of 2
                bits[n] = 1;
            else if (((n-1) & 1) == 0)    // previous number even
                bits[n] = bits[n-1] + 1;
            else
                bits[n] = bits[n/2];    // even n = n/2 << 1 hence same bits
        }
        return bits;
    }
}