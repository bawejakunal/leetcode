// https://leetcode.com/problems/combination-sum-iv/description/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int ways[] = new int[target + 1];
        ways[0] = 1;
        for (int s = 0; s <= target; s++) {
            for (int n: nums) {
                if (n <= s) {
                    ways[s] += ways[s - n];
                }
            }
        }
        return ways[target];
    }
}