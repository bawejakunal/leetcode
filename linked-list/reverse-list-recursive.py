"""
    https://leetcode.com/problems/reverse-linked-list/
    Reverse a singly linked list.
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Solution class
    """
    def reverse_util(self, head, tail):
        """
            returns tuple as head and tail
        """
        if head is None or head.next is None:
            tail = head
            return head, tail

        current = head
        head, tail = self.reverse_util(head.next, tail)
        tail.next = current
        tail = tail.next

        return head, tail


    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        tail = None
        head, tail = self.reverse_util(head, tail)
        # Do not miss this else a loop at end of linked list
        if tail is not None:
            tail.next = None

        return head

def printlist(head):
    """
        print linked list
    """
    current = head
    while current is not None:
        print current.val
        current = current.next

def main():
    """
        main method
    """
    solution = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head = solution.reverseList(head)
    printlist(head)

if __name__ == '__main__':
    main()
