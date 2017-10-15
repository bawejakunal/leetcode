// https://leetcode.com/problems/regular-expression-matching/description/

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();
        
        boolean first_match = (!text.isEmpty() && 
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (first_match && isMatch(text.substring(1), pattern)) || isMatch(text, pattern.substring(2));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
