# https://leetcode.com/problems/factorial-trailing-zeroes/


"""
n! = 1 * 2 * 3 * 4 ......... n
We need min(count_of_2, count_of_5)
2 is abundant than 5, hence dominated by 5
count_of_5 = n/5 + n/25 + n/125 + n/625 ..........

Below is recursive solution for that
"""


class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        return 0 if n == 0 else n // 5 + self.trailingZeroes(n // 5)
        