// https://leetcode.com/problems/move-zeroes/

public class Solution {
    public void moveZeroes(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < end; j++)
                    nums[j] = nums[j+1];
                nums[end] = 0;
                end--;
            }
        }
    }
}