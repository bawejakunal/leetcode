// https://leetcode.com/problems/paint-fence/description/

class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (n == 1)
            return k;
        int sameColor = k;  // previous 2 have same color
        int diffColor = k * (k-1);  // previous two have diff color
        for (int i = 2; i < n; i++) {
            int temp = diffColor;
            diffColor = (sameColor + diffColor) * (k-1);    // diff for i and i-1
            sameColor = temp;   // same for i and i-1, only 1 way to pick same as i-1
        }
        return diffColor + sameColor;
    }
}