// https://leetcode.com/problems/regular-expression-matching/description/

class Solution {
    public boolean isMatch(String text, String pattern) {
        // base case of empty string and empty pattern
        if (pattern.isEmpty())
            return text.isEmpty();
        
        // match first character of text
        // the text should be non empty and first character
        // should match with first char of pattern or first
        // char of pattern should be a dot (.) i.e wildcard
        boolean first = !text.isEmpty() && 
            (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        
        // the first character may match with an 'a*' or '.*' 
        // OR not match at all in which case you check with rest of the pattern
        if (pattern.length() >= 2 && pattern.charAt(1) == '*')
            return (first && isMatch(text.substring(1), pattern)) || isMatch(text, pattern.substring(2));
        else
            return first && isMatch(text.substring(1), pattern.substring(1)); // first char of pattern and text match without '*' in second place
    }
}
