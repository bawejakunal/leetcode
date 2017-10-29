// https://leetcode.com/problems/rectangle-area/discuss/

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ar = (C-A) * (D-B);
        ar += (G-E) * (H-F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        if (right > left && top > bottom)
            ar -= (right - left) * (top - bottom);
        return ar;
    }
}