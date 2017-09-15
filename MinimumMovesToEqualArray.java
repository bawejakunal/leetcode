// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];     // they will meet at some number mid way
            i++;
            j--;
        }
        return count;
    }
}