// https://leetcode.com/problems/maximum-average-subarray-i/#/description

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int cumulative[] = new int[nums.length];
        cumulative[0] = nums[0];
        for (int i = 1; i < k; i++)
            cumulative[i] = cumulative[i-1] + nums[i];
        int maxSum = cumulative[k-1];
        for (int i = k; i < nums.length; i++) {
            cumulative[i] = cumulative[i-1] - nums[i-k] + nums[i];
            if (maxSum < cumulative[i])
                maxSum = cumulative[i];
        }
        return (double)maxSum/k;
    }
}