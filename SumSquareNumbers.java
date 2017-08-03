// https://leetcode.com/problems/sum-of-square-numbers

public class Solution {
    public boolean judgeSquareSum(int c) {
        int b = c;
        for (int a = 0; a <= b; a++) {
            int b2 = c - (a*a);
            b = (int)Math.sqrt(b2);
            if (b2 == b*b)
                return true;
        }
        return false;
    }
}
