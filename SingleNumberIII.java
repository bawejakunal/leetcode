// https://leetcode.com/problems/single-number-iii/description/

class Solution {
    public int[] singleNumber(int[] nums) {
        int []ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                ans[idx++] = entry.getKey();
        }
        return ans;
    }

    public int[] singleNumber(int[] nums) {
        int []ans = {0, 0};
        int xor = 0;
        for (int num: nums)
            xor ^= num;
        
        // find any arbitrary set bit
        // example last set bit
        xor &= -xor;
        
        // now nums can be divided into two categories
        // those with bit set same as xor and others with the xor bit unset
        // take xor of individual groups, since each has a single element we 
        // get the answer
        for (int num : nums) {
            if ((num & xor) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        return ans;
    }
}