"""
    https://leetcode.com/problems/add-binary/

"""
class Solution(object):

    def binToInt(self, a):
        a_int = 0
        a = reversed(a)
        power = 2**0
        for digit in a:
            a_int += int(digit) * power
            power *= 2

        return a_int

    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        string = ""
        a_int = self.binToInt(a)
        b_int = self.binToInt(b)
        c = a_int + b_int
        if c == 0:
            return str(c)

        while c > 0:
            if c % 2 == 0:
                string = "0" + string
            else:
                string = "1" + string
            
            c /= 2
        
        return string
        