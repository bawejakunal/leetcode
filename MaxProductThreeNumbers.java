// https://leetcode.com/problems/maximum-product-of-three-numbers

public class Solution {
    public int maximumProduct(int[] nums) {
        // idx of largest num
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        
        int maxProduct = nums[maxIdx];    // max element is always included in product
        
        int maxNeg = 0, secNeg = 0, maxPos = 0, secPos = 0;
        for (int i = 0; i < nums.length; i++) {
            
            // skip max element
            if (i == maxIdx)
                continue;
            
            if (nums[i] < 0) {
                if (nums[i] < maxNeg) {
                    secNeg = maxNeg;
                    maxNeg = nums[i];
                }
                else if (nums[i] < secNeg)
                    secNeg = nums[i];
            }
            else {
                if (nums[i] > maxPos) {
                    secPos = maxPos;
                    maxPos = nums[i];
                }
                else if (nums[i] > secPos)
                    secPos = nums[i];
            }
        }
        
        int t1 = maxNeg * secNeg;
        int t2 = maxPos * secPos;
        maxProduct *= t1 > t2 ? t1: t2;
        
        return maxProduct;
    }
}