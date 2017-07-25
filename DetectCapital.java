// https://leetcode.com/problems/detect-capital

public class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("^$|[A-Z]+|[a-z]+|^[A-Z][a-z]+$");
    }
}