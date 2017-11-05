// https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n: nums)
            set.add(n);

        int longest = 0;
        for (int num: set) {
            //  new number to count up from
            if (!set.contains(num - 1)) {
                int current = 1;
                while (set.contains(num + 1)) {
                    num += 1; // counting upwards
                    current += 1;   // size of current sequence
                }
                longest = Math.max(current, longest);
            }
        }
        return longest;
    }
}