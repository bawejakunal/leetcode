// https://leetcode.com/problems/valid-perfect-square/

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2; // difference of two consecutive integer's squares increments by 2
        }
        return num == 0;
    }
}