// https://leetcode.com/problems/max-area-of-island/description/

class Solution {
    
    private int dfs(int [][]grid, int r, int c) {
        grid[r][c] = 0;   // mark visited
        int a = 1;
        if (r > 0 && grid[r-1][c] == 1)
            a += dfs(grid, r-1, c);
        if (r < grid.length - 1 && grid[r+1][c] == 1)
            a += dfs(grid, r+1, c);
        if (c > 0 && grid[r][c-1] == 1)
            a += dfs(grid, r, c-1);
        if (c < grid[r].length - 1 && grid[r][c+1] == 1)
            a += dfs(grid, r, c+1);
        return a;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0;c < grid[r].length; c++)
                if (grid[r][c] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
        return maxArea;
    }
}