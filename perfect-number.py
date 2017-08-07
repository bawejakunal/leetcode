# https://leetcode.com/problems/perfect-number

import math

class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num < 2:
            return False
        _sum = 1
        for d in range(2, int(math.ceil(math.sqrt(num)))):
            if 0 == num % d:
                _sum += d + (num / d)
            if _sum > num:
                break
        return _sum == num
