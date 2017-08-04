// https://leetcode.com/problems/palindrome-number

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0))
            return false;
        int sum = 0;
        int y = x;
        while (y > sum) {
            sum *= 10;
            sum += y % 10;
            y /= 10;
        }
        return (sum == y) || (y == sum / 10);   // even or odd digits in x (before while loop)
    }
}