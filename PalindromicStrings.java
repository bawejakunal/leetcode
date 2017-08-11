// https://leetcode.com/problems/palindromic-substrings/

public class Solution { 
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    
    public int countSubstrings(String s) {
        HashMap<String, Integer> palindromes = new HashMap<String, Integer>();
        Integer count = 0;
        for (int strt = 0; strt < s.length(); strt++) {
            for (int end = strt + 1; end <= s.length(); end++) {
                String sub = s.substring(strt, end);
                if (palindromes.containsKey(sub))
                    palindromes.put(sub, palindromes.get(sub) + 1);
                else if (isPalindrome(sub))
                    palindromes.put(sub, 1);
            }
        }
        for (Integer n: palindromes.values())
            count += n;
        return count.intValue();
    }
}