// https://leetcode.com/problems/4sum-ii/description/

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int a: A) {
            for (int b: B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int ans = 0;
        for (int c: C) {
            for (int d: D) {
                int neg = (c + d) * -1;
                ans += map.getOrDefault(neg, 0);
            }
        }
        return ans;
    }
}