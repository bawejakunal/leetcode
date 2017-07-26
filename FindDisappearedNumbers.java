// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappear = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)  // if not visited
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                disappear.add(i+1); // ith index never visited
        }
        return disappear;
    }
}