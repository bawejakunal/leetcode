// https://leetcode.com/problems/valid-palindrome-ii/description/

class Solution {
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        if (s == null)
            return true;
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(l + 1, r + 1)) || isPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return true;
    }
}