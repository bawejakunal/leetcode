// https://leetcode.com/problems/length-of-last-word

import java.util.regex.*;

public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ") - 1;
    }
}