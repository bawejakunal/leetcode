"""
    https://leetcode.com/problems/roman-to-integer/
"""

class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = list(s)
        num = 0
        prev = None
        current = None
        while len(stack) > 0:
            
            current = stack.pop()
            
            if current == 'I':
                if prev is not None and (prev == 'V' or prev == 'X'):
                    num -= 1
                else:
                    num += 1
            
            elif current == 'V':
                num += 5
            
            elif current == 'X':
                if prev is not None and (prev == 'L' or prev == 'C'):
                    num -= 10
                else:
                    num += 10
            
            elif current == 'L':
                num += 50
            
            elif current == 'C':
                if prev is not None and (prev == 'D' or prev == 'M'):
                    num -= 100
                else:
                    num += 100
            
            elif current == 'D':
                num += 500
            
            elif current == 'M':
                num += 1000
                        
            prev = current
        
        return num