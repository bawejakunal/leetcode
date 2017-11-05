// https://leetcode.com/problems/increasing-triplet-subsequence/description/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int []length = new int[nums.length];
        Arrays.fill(length, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && length[j] >= length[i]) {
                    length[i] = length[j] + 1;
                    if (length[i] == 3)
                        return true;
                }
            }
        }
        return false;
    }
}