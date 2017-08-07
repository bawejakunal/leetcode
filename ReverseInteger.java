// https://leetcode.com/problems/reverse-integer/description/

public class Solution {
    public int reverse(int x) {
        int y = x < 0 ? -x: x;
        int rev = 0;
        while (y > 0) {
            if (rev > 214748364)
                return 0;       // overflow
            rev *= 10;
            int d = y % 10;
            if (rev == 2147483640 && d > 8)
                return 0;
            rev += d;
            y /= 10;
        }
        if (x < 0)
            rev *= -1;
        return rev;
    }
}