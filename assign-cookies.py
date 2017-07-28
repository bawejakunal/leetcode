# https://leetcode.com/problems/assign-cookies/

class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        i = j = 0
        while i < len(g) and j < len(s):
            while j < len(s) and g[i] > s[j]:
                j += 1
            if j < len(s):
                i += 1
                j += 1  # one child satisfied
        return i
                