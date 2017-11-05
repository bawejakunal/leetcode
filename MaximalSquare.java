// https://leetcode.com/problems/maximal-square/description/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];   // previous row solutions
        int maxsqsize = 0, prev = 0;     // prev is cell to the left of current cell
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqsize = Math.max(maxsqsize, dp[j]); // update largest square size
                } else {
                    dp[j] = 0;  // not part of any square
                }
                prev = temp;
            }
        }
        return maxsqsize * maxsqsize;
    }
}