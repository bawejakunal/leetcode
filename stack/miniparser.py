"""
    https://leetcode.com/problems/mini-parser/
    Given a nested list of integers represented as a string, implement a parser to deserialize it.

    Each element is either an integer, or a list -- whose elements may also be
    integers or other lists.

    Note: You may assume that the string is well-formed:

    String is non-empty.
    String does not contain white spaces.
    String contains only digits 0-9, [, - ,, ].
"""

class Solution(object):
    """
        Leetcode solution class
    """
    def deserialize(self, string):
        """
        :type s: str
        :rtype: NestedInteger
        """
        stack = list(string)
        current = None
        prev = None

        # remove ']' from end
        while len(stack) and stack[-1] == ']':
            stack.pop()

        while len(stack) > 0:
            prev = current
            current = str()

            while len(stack) > 0 and stack[-1] != '[':
                current = stack.pop() + current

            # discard '['
            if len(stack) > 0:
                stack.pop() # pop '['
                
            if len(stack) > 0:
                stack.pop() # pop ','

            try:
                current = int(current)
            except ValueError:
                # empty NestedInteger passed
                current = None


            if current is None:
                # empty NestedInteger passed
                current = list()
            else:
                current = [current]

            if prev is not None:
                current.append(prev)

        return current

def main():
    """
        Demo nested integer
        Leetcode NestedInteger class is buggy
        so demo via lists
    """
    solution = Solution()
    print solution.deserialize("324")
    print solution.deserialize("[]")
    print solution.deserialize("[123,[456,[789]]]")

if __name__ == '__main__':
    main()
