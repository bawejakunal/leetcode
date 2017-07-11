// https://leetcode.com/problems/longest-palindrome

public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> characters = new HashSet<Character>();
        int length = 0;
        for (Character c: s.toCharArray()) {
            if (characters.contains(c)) {
                characters.remove(c);
                length += 2;
            }
        else
            characters.add(c);
        }
        if (!characters.isEmpty())
            length++;
        return length;
    }
}