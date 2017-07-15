"""
    https://leetcode.com/problems/implement-queue-using-stacks/
    Implement the following operations of a queue using stacks.
    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.
"""
class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st = list()
        self.st.append(list())
        self.st.append(list())
        self._turn = 0


    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.st[self._turn].append(x)


    def pop(self):
        """
        :rtype: nothing
        """
        if self.empty():
            return

        other = 1 - self._turn
        while True:
            try:
                pop = self.st[self._turn].pop()
                self.st[other].append(pop)
            except IndexError:
                break

        self.st[other].pop()

        while True:
            try:
                pop = self.st[other].pop()
                self.st[self._turn].append(pop)
            except IndexError:
                break
            


    def peek(self):
        """
        :rtype: int
        """
        if self.empty():
            return -1

        other = 1 - self._turn
        while True:
            try:
                pop = self.st[self._turn].pop()
                self.st[other].append(pop)
            except IndexError:
                break
        top = self.st[other][-1]
        while True:
            try:
                pop = self.st[other].pop()
                self.st[self._turn].append(pop)
            except IndexError:
                break

        return top 

    def empty(self):
        """
        :rtype: bool
        """
        try:
            top = self.st[self._turn][-1]
            return False
        except IndexError:
            return True


def main():
    """
        demo main method
    """
    queue = Queue()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    print queue.peek()
    queue.pop()
    print queue.empty()
    queue.pop()
    queue.pop()
    print queue.empty()

if __name__ == '__main__':
    main()
