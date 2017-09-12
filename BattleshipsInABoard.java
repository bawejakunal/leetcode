// https://leetcode.com/problems/battleships-in-a-board/description/

class Solution {
    
    boolean isNewShip(char [][]board, int row, int col) {
        
        boolean ans = (0 <= row && row < board.length && 0 <= col &&
                col < board[row].length && board[row][col] == 'X');
        
        if (ans == true && row > 0)
            ans = ans && (board[row-1][col] == '.');
        
        if (ans == true && col > 0)
            ans = ans && (board[row][col-1] == '.');
        
        return ans;
    }
    
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                count += isNewShip(board, row, col) ? 1 : 0;
        return count;
    }
}