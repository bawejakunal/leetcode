// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] cost = new int[s1.length() + 1][s2.length() + 1];
        
        // s1 to s2 (empty string)
        for(int i = 1; i < cost.length; i++){
            cost[i][0] = cost[i-1][0] + s1.charAt(i-1);
        }
        
        // s2 to s1 (empty string)
        for(int i = 1; i < cost[0].length; i++){
            cost[0][i] = cost[0][i-1] + s2.charAt(i-1);
        }

        for(int i = 1; i < cost.length; i++){
            for(int j = 1; j < cost[i].length; j++){
                int delboth = (s1.charAt(i-1) == s2.charAt(j-1)) ? 0 : s1.charAt(i-1) + s2.charAt(j-1);
                cost[i][j] = Math.min(cost[i-1][j] + s1.charAt(i-1), cost[i][j-1] + s2.charAt(j-1)); // delete one of the chars
                cost[i][j] = Math.min(cost[i][j], cost[i-1][j-1] + delboth);
            }
        }
        return cost[s1.length()][s2.length()];
    }
}