// https://leetcode.com/problems/predict-the-winner/description/

class Solution {
    
    private int minimax(int[] nums, int s, int e, int t) {
        if (s == e)
            return t * nums[s];
        int a = t * nums[s] + minimax(nums, s+1, e, -t);
        int b = t * nums[e] + minimax(nums, s, e-1, -t);
        return t * Math.max(t*a, t*b);  // return min for p2 and max for p1
    }
    
    public boolean PredictTheWinner(int[] nums) {
        return minimax(nums, 0, nums.length - 1, 1) >= 0;
    }
}