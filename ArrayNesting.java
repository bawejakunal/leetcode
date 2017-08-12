// https://leetcode.com/problems/array-nesting

public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int j = nums[i], size = 0;
                do {
                    j = nums[j];
                    size++;
                    visited[j] = true;
                }
                while (j != nums[i]);
                res = Math.max(res, size);
            }
        }
        return res;
    }
}