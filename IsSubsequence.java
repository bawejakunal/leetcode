// https://leetcode.com/problems/is-subsequence/discuss/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        int sl = 0;
        for (int i = 0; i < t.length() && sl < s.length(); i++) {
            if (t.charAt(i) == s.charAt(sl)) {
                ++sl;
            }
        }
        return sl == s.length();
    }
}