"""
    https://leetcode.com/problems/min-stack/
    Design a stack that supports push, pop, top, and retrieving the minimum
    element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
"""

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        # store as a tuple of (x,minimum)
        minimum = self.getMin()
        if minimum is None or x < minimum:
            minimum = x
        self.stack.append((x, minimum))
        

    def pop(self):
        """
        :rtype: void
        """
        try:
            self.stack.pop()
        except IndexError:
            return
        

    def top(self):
        """
        :rtype: int
        """
        try:
            s_top = self.stack[-1][0]
            return s_top
        except IndexError:
            return -1
        

    def getMin(self):
        """
        :rtype: int
        """
        try:
            minimum = self.stack[-1][1]
            return minimum
        except IndexError:
            return None

def main():
    """
        demo min stack
    """
    stack = MinStack()
    stack.push(3)
    print stack.top()
    stack.pop()
    stack.push(1)
    stack.push(3)
    stack.push(4)
    print stack.getMin()

if __name__ == '__main__':
    main()
