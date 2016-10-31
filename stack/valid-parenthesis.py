"""
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    https://leetcode.com/problems/valid-parentheses/
"""
class Solution(object):
    """
        check valid order of parenthesis
    """
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = list()
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            
            else:
                try:
                    top = stack.pop()
                    if c == ')' and top == '(':
                        continue
                    elif c == '}' and top == '{':
                        continue
                    elif c == ']' and top == '[':
                        continue
                    else:
                        return False
                
                except IndexError:
                    # stack is empty when we get a closing parenthesis
                    return False
        
        if len(stack) == 0:
            return True
        
        # if stack not empty unbalanced parenthesis
        return False


def main():
    """
        Demo code
    """
    solution = Solution()
    string = "{([])}[]"
    print solution.isValid(string)
    print solution.isValid(string[:-1])


if __name__ == '__main__':
    main()

