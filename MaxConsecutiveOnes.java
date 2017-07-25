// https://leetcode.com/problems/max-consecutive-ones/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1)
                nums[i] += nums[i-1];   // cumulative sum
        }
        int maxOnes = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > maxOnes)
                maxOnes = nums[i];
        return maxOnes;
    }
}