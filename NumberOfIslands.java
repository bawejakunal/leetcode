// https://leetcode.com/problems/number-of-islands/description/

class Solution {
    
    private void dfsMarkIsland(char [][]grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length)
            return;
        if (grid[r][c] != '1')
            return;
        
        grid[r][c] = '2';
        
        dfsMarkIsland(grid, r + 1, c);
        dfsMarkIsland(grid, r - 1, c);
        dfsMarkIsland(grid, r, c - 1);
        dfsMarkIsland(grid, r, c + 1);
    }
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    int[]p = {r, c};
                    dfsMarkIsland(grid, r, c);
                }
            }
        }
        return islands;
    }
}