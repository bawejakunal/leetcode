// https://leetcode.com/problems/relative-ranks/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int numsCopy[] = nums.clone();  // copy of nums
        Arrays.sort(numsCopy);   // increasing order
        String medals[] = new String[nums.length];
        HashMap<Integer,Integer> ranks = new HashMap<Integer, Integer>();
        for (int i=0; i < numsCopy.length;i++)
            ranks.put(numsCopy[i], numsCopy.length-i);    // rank is offset by 1
        
        for (int i = 0; i < nums.length; i++) {
            int pos = ranks.get(nums[i]);
            if (pos == 1)
                medals[i] = "Gold Medal";
            else if (pos == 2)
                medals[i] = "Silver Medal";
            else if (pos == 3)
                medals[i] = "Bronze Medal";
            else
                medals[i] = Integer.toString(pos);
        }
        return medals;
    }
}