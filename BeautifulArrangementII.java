// https://leetcode.com/problems/beautiful-arrangement-ii/discuss/

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 == 1 ? l++ : r--) : l++;
        return res;
    }
}