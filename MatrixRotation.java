class Solution {
    public void rotate(int[][] matrix) {
        int end = matrix.length - 1;
        for (int r = 0; r <= end;--end, ++r) {
            for (int c = r; c < end; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[end-c][r];
                matrix[end-c][r] = matrix[end][end-c];
                matrix[end][end-c] = matrix[c][end];
                matrix[c][end] = temp;
            }
        }
    }
}