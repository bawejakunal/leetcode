// https://leetcode.com/problems/excel-sheet-column-title/#/description

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        int col = n;
        do {
            int alphaNum = (col-1) % 26;
            col -= alphaNum + 1;
            col /= 26;
            alphaNum += 65; // ascii value
            builder.append((char)alphaNum);
        } while(col > 0);
        return builder.reverse().toString();
    }
}