// https://leetcode.com/problems/word-search/description/

class Solution {
    
    private int[][] direction = {{-1, 0}, {1, 0},
                               {0, -1}, {0, 1}};

    private boolean dfs(char [][]board, String word, int idx, int r, int c) {
        // consumed word
        if (idx == word.length())
            return true;
        // backtrack
        if (board[r][c] != word.charAt(idx))
            return false;
        
        board[r][c] ^= 256;    // mark visited
        for (int[] dir : this.direction) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[nr].length) {
                if (dfs(board, word, idx + 1, nr, nc))
                    return true;
            }
        }
        
        board[r][c] ^= 256;     // unmark unvisited
        return idx == word.length() - 1; // could be last character but no neighbors to visit
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (dfs(board, word, 0, r, c))
                    return true;
            }
        }
        return false;
    }
}