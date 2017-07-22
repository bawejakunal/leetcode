// https://leetcode.com/problems/search-insert-position/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = 0;
        while (idx < nums.length && nums[idx] < target)
            idx++;
        return idx;
    }
}