// https://leetcode.com/problems/sum-of-two-integers/

public class Solution {
    public int getSum(int a, int b) {
        int sum = b ^ a;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int base = sum ^ carry;
            carry = (carry & sum) << 1;
            sum = base;
        }
        return sum;
    }
}