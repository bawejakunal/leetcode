// https://leetcode.com/problems/sparse-matrix-multiplication/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];
        
        // each row in A
        for (int r = 0; r < A.length; r++) {
            // each element in A[r]
            for (int c = 0; c < A[r].length; c++) {
                // skip whole corrsponding row: B[c]
                if (A[r][c] != 0) {
                    // each element in B[c] row
                    for (int i = 0; i < B[c].length; i++) {
                        // multiply
                        ans[r][i] += A[r][c] * B[c][i];
                    }
                }
            }
        }
        return ans;
    }
}