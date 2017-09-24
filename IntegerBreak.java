// https://leetcode.com/problems/integer-break/description/

class Solution {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        int products[] = new int[n+1];
        products[1] = 1;
        for (int num = 2; num <= n; num++) {
            for (int p = 1; p <= num/2; p++) {
                int f = num - p;
                products[num] = Math.max(products[num], p * Math.max(f, products[f]));
            }
        }
        return products[n];
    }
}