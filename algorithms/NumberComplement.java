// https://leetcode.com/problems/number-complement

public class Solution {
    public int findComplement(int num) {
        int shift = 1;
        while (num >>> shift != 0)
            shift++;
        int ans = (~num) & ((1 << shift) - 1);
        return ans;
    }
}