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
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head

        current = None
        while head.next is not None:
            temp = head.next
            head.next = current
            current = head
            head = temp
        head.next = current

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
