"""
    https://leetcode.com/problems/add-binary/
"""
class Solution(object):
    """
        Leetcode Solution Class
    """
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        string = ""
        a_int = int(a, 2)
        b_int = int(b, 2)
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


def main():
    """
        Example run
    """
    solution = Solution()
    print solution.addBinary('0110', '0110')


if __name__ == '__main__':
    main()
