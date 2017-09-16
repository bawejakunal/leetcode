// https://leetcode.com/problems/minesweeper/description/

class Solution {
    
    boolean isValid(char[][] board, int []pos) {
        return (0 <= pos[0] && pos[0] < board.length &&
                0 <= pos[1] && pos[1] < board[pos[0]].length);
    }
    
    boolean isVisited(char[][] board, int []pos) {
        int r = pos[0], c = pos[1];
        return (board[r][c] == 'B' || board[r][c] == 'X' || 
                ('1' <= board[r][c] && board[r][c] <= '8'));
    }
    
    void reveal(char [][]board, int []pos) {
        int countAdjacent = 0;
        for (int row = pos[0] - 1; row < pos[0] + 2; row++) {
            for (int col = pos[1] - 1; col < pos[1] + 2; col++) {
                int nbr[] = {row, col};
                if (row == pos[0] && col == pos[1])
                    continue;
                if (isValid(board, nbr) && board[nbr[0]][nbr[1]] == 'M')
                    countAdjacent += 1;
            }
        }
        
        if (countAdjacent > 0) {
            board[pos[0]][pos[1]] = Character.forDigit(countAdjacent, 10);
            return;
        }
        else {
            board[pos[0]][pos[1]] = 'B';
            
            for (int row = pos[0] - 1; row < pos[0] + 2; row++) {
                for (int col = pos[1] - 1; col < pos[1] + 2; col++) {
                    
                    if (row == pos[0] && col == pos[1])
                        continue;
                    
                    int nbr[] = {row, col};
                    if (isValid(board, nbr) && !isVisited(board, nbr))
                        reveal(board, nbr);
                }
            }
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (!isValid(board, click))
            return board;
        
        // 
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';    // mine clicked game over
            return board;
        }
        
        // reveal the safe cell
        if (board[click[0]][click[1]] == 'E')
            reveal(board, click);
        
        return board;
    }
}
