// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int total = 0, maxLength = 0;
        // hashmap [sum, smallest array from start]
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == k)
                maxLength = i + 1;  // from 0 till ith idx
            else if (map.containsKey(total - k))
                maxLength = Math.max(maxLength, i - map.get(total - k));
            

            /* We can have multiple cumulative sum with same value
               but that essentially means the trailing part of longer
               subarray for a given sum has subarray sum as 0, which does
               nothing but reduce the size of our potential maxSubArray
            */
            if (!map.containsKey(total))
                map.put(total, i);
        }
        return maxLength;
    }
}