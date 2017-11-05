// https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int lens[] = new int[nums.length];
        Arrays.fill(lens, 0);
        int maxlen = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(lens, 0, maxlen, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            lens[idx] = num;
            if (idx == maxlen)
                maxlen++;
        }
        return maxlen;
    }
}