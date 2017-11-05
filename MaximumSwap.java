// https://leetcode.com/problems/maximum-swap/description/

class Solution {
    public int maximumSwap(int num) {
        char []digits = Integer.toString(num).toCharArray();
        int []last = new int[10];
        for (int i = 0; i < digits.length; i++)
            last[digits[i] - '0'] = i;  // update last occurrence of digits
        
        for (int i = 0; i < digits.length; i++) {
            // check if a greater digit occurs later
            // if yes, swap and return
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}