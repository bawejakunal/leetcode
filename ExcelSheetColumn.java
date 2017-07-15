// https://leetcode.com/problems/excel-sheet-column-number/#/description

public class Solution {
    public int titleToNumber(String s) {
        int cols = 0;
        for (int i = 1; i <= s.length(); i++) {
            int alphaNum = 1 + (int)s.charAt(i-1) - (int)'A';
            cols += Math.pow(26, s.length()-i) * alphaNum;
        }
        return cols;
    }
}