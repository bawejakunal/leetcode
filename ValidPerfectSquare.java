// https://leetcode.com/problems/valid-perfect-square/

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2; // sum of odd numbers is a perfect square
        }
        return num == 0;
    }
}
