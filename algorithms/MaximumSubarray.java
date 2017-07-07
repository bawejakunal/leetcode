// https://leetcode.com/problems/maximum-subarray/

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1)
            return 0;
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum[i] = maxSum[i-1] + nums[i];
            if (nums[i] > maxSum[i])
                maxSum[i] = nums[i];
        }
        int max = maxSum[0];
        for (int i  = 0; i < maxSum.length; i++)
            if (maxSum[i] > max)
                max = maxSum[i];
        return max;
    }
}