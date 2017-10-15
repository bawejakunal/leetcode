// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int total = 0, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == k)
                maxLength = i + 1;  // from 0 till ith idx
            else if (map.containsKey(total - k))
                maxLength = Math.max(maxLength, i - map.get(total - k));
            if (!map.containsKey(total))
                map.put(total, i);
        }
        return maxLength;
    }
}