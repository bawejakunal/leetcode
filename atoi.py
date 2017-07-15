'''
    Implement atoi() from C/C++
    https://leetcode.com/problems/string-to-integer-atoi/
'''

INT_MAX = 2147483647
INT_MIN = -2147483648

class Solution(object):
    '''
        Solution class
    '''
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        digits = "0123456789"
        string = str.strip()
        numstr = ""
        num = None

        try:
            # get valid sign
            if string[0] in '+-':
                numstr += string[0]
                string = string[1:]

            # get only digits, else break
            for char in string:
                if char in digits:
                    numstr += char
                else:
                    break

            # typecast
            num = int(numstr)

            # lower limit
            if num > INT_MAX:
                return INT_MAX

            # upper limit
            elif num < INT_MIN:
                return INT_MIN

            return num

        except:
            return 0

def main():
    '''
        main method
    '''
    solution = Solution()
    print solution.myAtoi("-00123dfk567")
    print solution.myAtoi("+00786dfk567")
    print solution.myAtoi("12312312423423423423")
    print solution.myAtoi("3456")
    print solution.myAtoi("dfk567")

if __name__ == '__main__':
    main()