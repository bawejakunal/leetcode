# https://leetcode.com/problems/isomorphic-strings/

class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if s is None or t is None or len(s) != len(t):
            return False
        
        frwd = dict()
        bkwd = dict()
        for i in range(len(s)):
            if s[i] not in frwd and t[i] not in bkwd:
                frwd[s[i]] = t[i]
                bkwd[t[i]] = s[i]
            else:
                if not (frwd.get(s[i],'') == t[i] and bkwd.get(t[i],'') == s[i]):
                    return False
        return True
        