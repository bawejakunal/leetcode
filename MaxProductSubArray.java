//https://leetcode.com/problems/maximum-product-subarray

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length < 1)
            return 0;
        int[] maxProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProduct[i] = maxProduct[i-1] * nums[i];
            if (maxProduct[i] == 0)
                maxProduct[i] = nums[i];
        }
        
        int max = maxProduct[0];
        for (int i  = 0; i < maxProduct.length; i++) {
            if (maxProduct[i] < nums[i]) {
                int j = i - 1;
                int left = i-1;
                while (j >= 0 && nums[j] != 0) {
                    if (nums[j] < 0)
                        left = j;
                    j--;
                }
                while (left >=0 && nums[left] != 0) {
                    maxProduct[i] /= nums[left];
                    left--;
                }
            }
            if (maxProduct[i] > max)
                max = maxProduct[i];
        }
        return max;
    }
}