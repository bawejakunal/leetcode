"""
    https://leetcode.com/problems/roman-to-integer/
"""

class Solution(object):

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """

        # Store characters into a stack
        stack = list(s.upper())
        num = 0
        prev = None
        current = None
        roman = {
            "I" : 1,
            "V" : 5,
            "X" : 10,
            "L" : 50,
            "C" : 100,
            "D" : 500,
            "M" : 1000
        }

        # Stack not empty
        while len(stack) > 0:
            
            # pop character
            current = stack.pop()
            
            # conditions for constructing numbers in roman
            if current == 'I':
                if prev is not None and (prev == 'V' or prev == 'X'):
                    num -= roman['I']
                else:
                    num += roman['I']
            
            elif current == 'V':
                num += roman['V']

            elif current == 'X':
                if prev is not None and (prev == 'L' or prev == 'C'):
                    num -= roman['X']
                else:
                    num += roman['X']

            elif current == 'L':
                num += roman['L']

            elif current == 'C':
                if prev is not None and (prev == 'D' or prev == 'M'):
                    num -= roman['C']
                else:
                    num += roman['C']

            elif current == 'D':
                num += roman['D']

            elif current == 'M':
                num += roman['M']
            
            prev = current
        
        return num


def main():
    """
        main() method to demo
    """
    solution = Solution()
    print solution.romanToInt("XLIX")


if __name__ == '__main__':
    main()
