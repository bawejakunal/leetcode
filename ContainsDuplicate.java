// https://leetcode.com/problems/contains-duplicate/#/description

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int n: nums)
            numSet.add(n);
        return numSet.size() < nums.length;
    }
}