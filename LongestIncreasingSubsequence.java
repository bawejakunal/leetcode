// https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 0, current = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (i == 0 || nums[i] > nums[i-1])
                current++;
            else {
                longest = Math.max(current, longest);
                current = 1;
            }
        }
        return Math.max(longest, current);
    }
}