// https://leetcode.com/problems/power-of-three/#/description

public class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}

// Max int possible is Math.pow(3, 19) in 32 bit integers
// public class Solution {
//     public boolean isPowerOfThree(int n) {
//         return n > 0 && 1162261467 % n == 0;
//     }
// }