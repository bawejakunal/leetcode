// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int size = 0;
        for (int i = 0; i < nums.length;) {
            int j = i + 1;  // count duplicates duplicates
            while (j < nums.length && nums[j] == nums[i])
                j++;    // skip duplicates
            int count = Math.min(2, j - i); // count duplicates, maximum 2 allowed
            for (int k = 0; k < count; k++) // add duplicates in return array
                nums[size++] = nums[i];
            i = j;  // next number to scan from
        }
        return size;
    }
}