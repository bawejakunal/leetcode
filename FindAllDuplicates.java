// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new LinkedList<Integer>();
        for (int n: nums) {
            if (n < 0)
                n *= -1;
            if (nums[n-1] < 0)
                duplicates.add(n);
            else
                nums[n-1] *= -1;
        }
        return duplicates;
    }
}