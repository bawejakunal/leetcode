// https://leetcode.com/problems/edit-distance/description/

class Solution {
    
    // RECURSIVE O(3^m)
    // private int minDistance(String word1, int m, String word2, int n) {
    //     if (m == 0)
    //         return n;
    //     if (n == 0)
    //         return m;
        
    //     if (word1.charAt(m-1) == word2.charAt(n-1))
    //         return minDistance(word1, m-1, word2, n-1);
        
    //     return 1 + Math.min(minDistance(word1, m-1, word2, n-1),
    //             Math.min(minDistance(word1, m-1, word2, n),
    //                      minDistance(word1, m, word2, n-1)));
    // }
    
    // O(n^2) DYNAMIC PROGRAMMING
    private int minDistance(String word1, int m, String word2, int n) {
        int dist[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dist[i][j] = j; // insert
                else if (j == 0)
                    dist[i][j] = i; // delete
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1];  // ignore last chars
                else
                    dist[i][j] = 1 + Math.min(dist[i-1][j-1],   // replace
                                    Math.min(dist[i][j-1],      // insert
                                             dist[i-1][j]));    // delete
            }
        }
        return dist[m][n];
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word1.length(), word2, word2.length());
    }
}