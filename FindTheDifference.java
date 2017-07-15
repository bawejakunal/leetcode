// https://leetcode.com/problems/find-the-difference

public class Solution {
    public char findTheDifference(String s, String t) {
        char sChars[] = s.toCharArray();
        char tChars[] = t.toCharArray();
        char missing = (char)0;
        for (char c: sChars)
            missing ^= c;
        for (char c: tChars)
            missing ^= c;
        return missing;
    }
}