// https://leetcode.com/problems/minimum-size-subarray-sum/discuss/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
  
        int start = 0, end = 0, sum = 0, min = nums.length + 1;
  
        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }

        return min > nums.length ? 0 : min;
    }
}