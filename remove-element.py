# https://leetcode.com/problems/remove-element/#/description

class Solution(object):    
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        lngth = len(nums)
        i = 0
        while i < lngth:
            if nums[i] == val:
                nums[i], nums[lngth-1] = nums[lngth-1], nums[i]
                lngth -= 1
            else:
                i += 1
        return i
        