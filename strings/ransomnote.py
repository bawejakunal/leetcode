"""
    Rasom Note from Magazine characters
    https://leetcode.com/problems/ransom-note/
"""
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        d = dict()
        for char in magazine:
            if char not in d:
                d[char] = 1
            else:
                d[char] += 1
        
        for char in ransomNote:
            if char not in d:
                return False
            else:
                d[char] -= 1
                if d[char] < 0:
                    return False
        
        return True
        
        