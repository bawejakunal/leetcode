// https://leetcode.com/problems/two-sum

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pos = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (pos.containsKey(other))
                return new int[]{pos.get(other), i};
            pos.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
