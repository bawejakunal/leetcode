// https://leetcode.com/problems/rotate-array/

public class Solution { 
    private void rotate_index(int[] nums, int start, int end, int k) {
        int places = k % (end - start + 1);   // actual displacement required
        if (places > 0) {
            int i = start;
            int j = end - places + 1;
            while (i < start + places && j <= end) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
            if (i < end)    // array not exhausted
                rotate_index(nums, i, end, places);
        }
    }
    
    public void rotate(int[] nums, int k) {
        rotate_index(nums, 0, nums.length - 1, k);
    }

    /* alternate solution by reversing two parts of given array */
    // private void reverse(int nums[], int start, int end) {
    //     while (start < end) {
    //         int temp = nums[start];
    //         nums[start] = nums[end];
    //         nums[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }
    
    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;    // actual rotation required
    //     if (k > 0) {
    //         reverse(nums, 0, nums.length - 1);
    //         reverse(nums, 0, k-1);
    //         reverse(nums, k, nums.length - 1);
    //     }
    // }

}