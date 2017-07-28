# https://leetcode.com/problems/intersection-of-two-arrays

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        intersect = list()
        i = j = 0
        while i < len(nums1) and j < len(nums2):
            
            while i < len(nums1) and nums1[i] < nums2[j]:
                i += 1
            
            if i < len(nums1):
                while j < len(nums2) and nums2[j] < nums1[i]:
                    j += 1
            
            while i < len(nums1) and j < len(nums2) and nums1[i] == nums2[j]:
                if len(intersect) == 0:
                    intersect.append(nums1[i])
                elif intersect[-1] < nums1[i]:
                    intersect.append(nums1[i])
                i += 1
                j += 1
        
        return intersect