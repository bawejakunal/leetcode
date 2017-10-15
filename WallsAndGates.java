// https://leetcode.com/problems/walls-and-gates/description/

class Solution {
    
    private static int INF = Integer.MAX_VALUE;
    private static int GATE = 0;
    private static int[][]DIRECTION = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    /*start searching from the gates
      move one step at a time from each
      gate. If an empty room is reachable from two
      gates, the BFS from the nearer gate will end
      up there first and the room will be marked non
      empty so that other BFS does not overwrite it.
    */
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == GATE)
                    q.add(new int[]{r, c});
            }
        }
        
        while(!q.isEmpty()) {
            int []cell = q.poll();
            for (int[]dir: DIRECTION) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || row >= rooms.length || col < 0 ||
                    col >= rooms[row].length || rooms[row][col] != INF){
                    continue;
                }
                rooms[row][col] = rooms[cell[0]][cell[1]] + 1;
                q.add(new int[]{row, col});
            }
        }
    }
}