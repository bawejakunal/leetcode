"""
    Given a non-negative integer num represented as a string, remove k digits
    from the number so that the new number is the smallest possible.
    https://leetcode.com/problems/remove-k-digits/
"""

"""
    We delete the largest K digits in decreasing order of significance
    these affect the value most
    This is a greedy approach where the greed is for deleting the greater
    digit given a choice between two digits to reduce a number to a smaller
    number by eliminating one of the two digits
"""

class Solution(object):
    """
        Annoying Solution class leetcode is backs
    """
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if k >= len(num):
            return '0'

        elif k < 1:
            return num

        else:
            number = list(num)
            index = 0
            while k > 0:
                length = len(number)
                # delete largest digit you see
                while index < length - 1 and number[index] <= number[index+1]:
                    index += 1
                del number[index]
                # compare previous digit with new digit
                if index > 0:
                    index -= 1
                k -= 1

        return str(int("".join(number)))

def main():
    """
        Demo
    """
    number = "52660469"
    solution = Solution()
    print solution.removeKdigits(number, 2)

if __name__ == '__main__':
    main()
