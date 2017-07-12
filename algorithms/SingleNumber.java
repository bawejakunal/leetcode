// https://leetcode.com/problems/single-number

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int missing = 0;
        for (int n: nums)
            missing ^= n;
        return missing;
    }
}