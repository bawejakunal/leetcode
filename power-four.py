# https://leetcode.com/problems/power-of-four

class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return num > 0 and\
                num & (num-1) == 0 and\
                0b01010101010101010101010101010101 & num == num
        