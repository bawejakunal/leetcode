// https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new LinkedList<Integer>();
        
        if (matrix.length < 1)
            return spiral;
        int rs = 0, re = matrix.length - 1, cs = 0, ce = matrix[0].length - 1;
        while (rs <= re && cs <= ce) {
            // top row
            for (int c = cs; c <=ce ; c++) {
                spiral.add(matrix[rs][c]);
            }
            
            // right column
            for (int r = rs + 1; r <= re; r++) {
                spiral.add(matrix[r][ce]);
            }
            
            // bottom row
            if (rs < re) {
                for (int c = ce - 1; c >= cs; c--) {
                    spiral.add(matrix[re][c]);
                }
            }
            
            // first column
            if (cs < ce) {
                for (int r = re - 1; r > rs; r--)
                    spiral.add(matrix[r][cs]);
            }
            
            // change boundaries
            rs++;
            re--;
            cs++;
            ce--;
        }
        return spiral;
    }
}