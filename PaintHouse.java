// https://leetcode.com/problems/paint-house/description/

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        for (int h = 1; h < costs.length; h++) {
            costs[h][0] += Math.min(costs[h-1][1], costs[h-1][2]);
            costs[h][1] += Math.min(costs[h-1][0], costs[h-1][2]);
            costs[h][2] += Math.min(costs[h-1][0], costs[h-1][1]);
        }
        int h = costs.length - 1;
        return Math.min(costs[h][0], Math.min(costs[h][1], costs[h][2]));
    }
}