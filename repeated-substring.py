# https://leetcode.com/problems/repeated-substring-pattern/

class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        for lngth in range(1, 1 + len(s)//2):
            substr = s[:lngth]
            if substr * (len(s)//lngth) == s:
                return True
        return False
