"""
    https://leetcode.com/problems/implement-stack-using-queues/
    Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
"""

class Stack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.queue = list()
        self.queue.append(list())
        self.queue.append(list())
        self.turn = 0
        

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.queue[self.turn].append(x)
        

    def pop(self):
        """
        :rtype: nothing
        """
        if self.empty():
            return

        other = 1 - self.turn
        while True:
            first = self.queue[self.turn][0]
            del self.queue[self.turn][0]
            if self.empty():
                self.turn = other
                return
            else:
                self.queue[other].append(first)


    def top(self):
        """
        :rtype: int
        """
        if self.empty():
            return -1

        other = 1 - self.turn
        while True:
            first = self.queue[self.turn][0]
            del self.queue[self.turn][0]
            self.queue[other].append(first)
            if self.empty():
                self.turn = other
                return first
        

    def empty(self):
        """
        :rtype: bool
        """
        try:
            first = self.queue[self.turn][0]
            return False
        except IndexError:
            return True

def main():
    """
        demo of stack
    """
    stack = Stack()
    stack.push(1)
    print stack.top()

if __name__ == '__main__':
    main()
