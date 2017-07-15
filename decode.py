"""
    https://leetcode.com/problems/decode-string/
    Given an encoded string, return it's decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
"""

"""
    Assume valid inputs
"""

class Solution(object):
    """
        Leetcode solution class
    """
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        index = 0
        stack = list()
        decoded = str()
        for char in s:
            if char == ']':
                numstr = str()
                substr = str()

                """
                    no need to check empty stack here
                    always some digits preceding '['
                """
                while stack[-1] != '[':
                    substr = stack.pop() + substr
                stack.pop() # remove '['
                
                """
                    try/except helps to avoid checking
                    len(stack) > 0 on each iteration of
                    while loop. Slight efficiency
                """
                try:
                    while stack[-1].isdigit():
                        numstr = stack.pop() + numstr
                except IndexError:
                    # stack empty
                    pass

                # decode substring and update on stack
                stack.append(int(numstr)*substr)

            else:
                stack.append(char)

        while len(stack) > 0:
            decoded = stack.pop() + decoded

        return decoded

def main():
    """
        Demo
    """
    solution = Solution()
    print solution.decodeString("3[a2[c]]")

if __name__ == '__main__':
    main()
