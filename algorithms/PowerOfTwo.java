// https://leetcode.com/problems/power-of-two/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        int shift = 0;
        // only positive numbers possible hence signed shift
        while (n >> shift > 0)
            shift++;
        // if negative then false
        if ((n >> shift) < 0)   // negatives not allowed
            return false;
        // pow2 that it should equal
        int pow2 = 1 << (shift-1);
        return 0 == (pow2 ^ n); // xor of bits should be 0
    }
}