# https://leetcode.com/problems/set-mismatch

class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        errors = list()
        s = set()
        for num in nums:
            if num in s:
                errors.append(num)
            s.add(num)
        for i in range(1, len(nums) + 1):
            if i not in s:
                errors.append(i)
        return errors
        