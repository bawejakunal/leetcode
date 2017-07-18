// https://leetcode.com/problems/island-perimeter/#/description

public class Solution {
    private int countShores(int [][]grid, int row, int col) {
        int count = 0;
        if (row > 0)
            count += grid[row-1][col];
        
        if (row < grid.length - 1)
            count += grid[row+1][col];
        
        if (col > 0)
            count += grid[row][col-1];
        
        if (col < grid[row].length-1)
            count += grid[row][col+1];
        
        // till this point count accumulates number land sides
        count = 4 - count;  // we need number of shores
        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++)
                if (grid[r][c] == 1)
                    perimeter += countShores(grid, r, c);
        }
        return perimeter;
    }
}