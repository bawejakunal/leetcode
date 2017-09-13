// https://leetcode.com/problems/beautiful-arrangement/description/

class Solution {
    
    private int countWays(int idx, int N, int []visited) {
        int count = 0;
        if (idx > N)
            count = 1;      // valid permutation generated
        else {
            for (int num = 1; num <= N; num++) {
                if (visited[num] == 0 && ((num % idx == 0) || (idx % num == 0))) {
                    visited[num] = 1;         // mark visited i.e. placed in a valid way
                    count += countWays(idx + 1, N, visited);
                    visited[num] = 0; // mark as unvisited
                }
            }
        }
        return count;
    }
    
    public int countArrangement(int N) {
        int visited[] = new int[N + 1];
        int count = countWays(1, N, visited);
        return count;
    }
}