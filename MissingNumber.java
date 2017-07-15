// https://leetcode.com/problems/missing-number/

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int missing = 0;
        for (int i = 0; i <= nums.length; i++)
            missing ^= i;
        for (int n: nums)
            missing ^= n;
        return missing;
    }
}