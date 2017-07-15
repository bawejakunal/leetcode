// https://leetcode.com/problems/base-7/#/description

public class Solution {
    public String convertToBase7(int num) {
        StringBuilder base = new StringBuilder();
        int n = num;
        if (n < 0)
            n *= -1;    // make positive
        do {
            base.append(Integer.toString(n % 7));
            n /= 7;
        } while(n!=0);
        if (num < 0)
            base.append("-");
        return base.reverse().toString();
    }
}