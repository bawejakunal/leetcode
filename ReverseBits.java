// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for (int bits = 1; bits<=32; bits++) {
            reverse = (reverse << 1) + (n & 1);
            n >>>= 1;
        }
        return reverse;
    }
}