# https://leetcode.com/problems/reshape-the-matrix/#/description

class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        _r = len(nums)
        if _r < 1:
            return nums
        _c = len(nums[0])
        if _r*_c != r * c:
            return nums
        matrix = list()
        for nr in range(r):
            matrix.append(list())
            for nc in range(c):
                pos = nr * c + nc
                x = pos//_c
                y = pos % _c
                matrix[nr].append(nums[x][y])
        return matrix