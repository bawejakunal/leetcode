// https://leetcode.com/problems/summary-ranges/description/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new LinkedList<>();
        int start = 0, end = 0;
        
        if (nums == null || nums.length == 0)
            return ranges;
        
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            
            if (nums[i] == first)
                ranges.add(Integer.toString(first));
            else
                ranges.add(Integer.toString(first) + "->" +
                    Integer.toString(nums[i]));
        }
        
        return ranges;
    }
}