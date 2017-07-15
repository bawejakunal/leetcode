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
        stack = list()
        token = str()

        for char in string:
            if char == '[':
                # stack.append(NestedInteger())
                stack.append(list())

            elif char == ']' or char == ',':
                if len(token) > 0:
                    # stack[-1].add(NestedInteger(int(token)))
                    stack[-1].append(int(token))
                    token = str()

                if char == ']':
                    top = stack.pop()
                    if len(stack) > 0:
                        # stack[-1].add(top)
                        stack[-1].append(top)
                    else:
                        return top
            else:
                token += char

        if len(token) > 0:
            return int(token)

def main():
    """
        Demo nested integer
        Leetcode NestedInteger class is buggy
        so demo via lists
    """
    solution = Solution()

    print solution.deserialize("[-1,[3,2]]")
    print solution.deserialize("324")
    print solution.deserialize("[[]]")
    print solution.deserialize("[123,[456,[789]]]")

if __name__ == '__main__':
    main()
