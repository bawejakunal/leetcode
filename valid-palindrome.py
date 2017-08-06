# https://leetcode.com/problems/valid-palindrome
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        p = re.compile('[^A-Za-z0-9]')
        t = p.sub('', s).lower()
        l = 0
        r = len(t) - 1
        while l < r:
            if t[l] != t[r]:
                return False
            l += 1
            r -= 1
        return True
        