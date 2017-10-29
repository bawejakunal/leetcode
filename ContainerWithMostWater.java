// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0, l = 0, r = height.length - 1;
        while (l  < r) {
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxWater;
    }
}