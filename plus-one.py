# https://leetcode.com/problems/plus-one

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        result = list(reversed(digits))
        carry = 1
        i = 0
        while i < len(result) and carry > 0:
            digit = result[i] + carry
            carry = digit // 10
            digit %= 10
            result[i] = digit
            i += 1
        if carry > 0:
            result.append(carry)
        return result[::-1]