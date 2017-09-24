// https://leetcode.com/problems/diagonal-traverse/description/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        
        int m = matrix.length, n = matrix[0].length;
        int ans[] = new int[m * n];
        int dir[][] = {{-1, 1}, {1, -1}};
        
        int row = 0;
        int col = 0;
        int d = 0;  // upwards
        for (int i = 0; i < m * n; i++) {
            ans[i] = matrix[row][col];
            row += dir[d][0];
            col += dir[d][1];
            
            if (row >= m) {         // out of bottom row
                row = m - 1;
                col += 2;
                d = 1 - d;          // go upwards
            }
            else if (col >= n) {    // out of right side
                col = n - 1;
                row += 2;
                d = 1 - d;          // go downwards
            }
            else if (col < 0) {     // out of left border
                col = 0;
                d = 1 - d;          // go upwards
            }
            else if (row < 0) {     // out of top row
                row = 0;
                d = 1 - d;          // go downwards
            }
        }
        return ans;
    }
}