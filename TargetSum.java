// https://leetcode.com/problems/target-sum/description/

class Solution {
    
    private int findTargetSumWays(int []nums, int idx, int S) {
        if (nums == null || nums.length < 1)
            return 0;
        if (idx == nums.length)
            return S == 0 ? 1 : 0;
        return (findTargetSumWays(nums, idx + 1, S - nums[idx]) + 
                findTargetSumWays(nums, idx + 1, S + nums[idx]));
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }
}