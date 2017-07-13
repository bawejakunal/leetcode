// https://leetcode.com/problems/majority-element/#/description

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, majority=0;
        for  (int n: nums) {
            if (count == 0) {
                count++;
                majority = n;
            }
            else if (n == majority)
                count++;
            else
                count--;
        }
        return majority;
    }
}