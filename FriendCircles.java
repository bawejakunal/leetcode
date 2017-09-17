// https://leetcode.com/problems/friend-circles/description/

class Solution {
    
    private void dfs(int [][]M, int []visited, int i) {
        visited[i] = 1; // visiting current friend
        for (int j = 0; j < M[i].length; j++)
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
    }
    
    public int findCircleNum(int[][] M) {
        int []visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++)
            if (visited[i] == 0) {
                count++;
                dfs(M, visited, i);
            }
        return count;
    }
}