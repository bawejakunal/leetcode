// https://leetcode.com/problems/sort-colors/description/

class Solution {
    
    private void swap(int []nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // private int sort(int[] nums, int start, int color) {
    //     int pos = start;
    //     for (int i = start; i < nums.length; i++) {
    //         if (nums[i] == color) {
    //             swap(nums, i, pos);
    //             pos++;
    //         }
    //     }
    //     return pos;
    // }
    
    // public void sortColors(int[] nums) {
    //     int p = 0;
    //     int c = sort(nums, 0, 0);
    //     c = sort(nums, c, 1);
    // }
    
    public void sortColors(int[] nums) {
        int c0 = 0, c2 = nums.length - 1, i = 0;
        while (i <= c2) {
            if (nums[i] == 0) {
                swap(nums, i, c0);
                c0++;   // next c0 position
                // i-- not required because all to left are 0s followed by 1
            }
            else if (nums[i] == 2) {
                swap(nums, i, c2);
                c2--;
                i--;    // dont miss swapped element from right which is unseen
            }
            // do nothing for nums[i] == 1; simply check next idx
            i++;    // see next index
        }
    }
}