// https://leetcode.com/problems/contiguous-array/description/

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (!map.containsKey(count))
                map.put(count, i);  // earliest index with a given count
            else {
                maxlen = Math.max(maxlen, i - map.get(count));  // update maxlen
                // betweem indices where relative count is same, we have equal
                // number of zeros and ones
            }
        }
        return maxlen;
    }
}