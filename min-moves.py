# https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        """
        Let it take m moves to reach equilibrium
        Let x be final value at equilibrium
        s = sum(list)
        n = len(list)
        minNum = min(list)
        
        x * n = s + (n-1) * m   // in each move sum increases by n-1
        (minNum + m) * n = s + m*n - m
        m = s - minNum * n
        """
        s = sum(nums)
        n = len(nums)
        minNum = min(nums)
        return s - (minNum * n)
