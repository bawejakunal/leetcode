"""
    https://leetcode.com/problems/remove-linked-list-elements/
    Remove all elements from a linked list of integers that have value val
"""

# Definition for singly-linked list.
class ListNode(object):
    """
        ListNode definition
    """
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Leetcode solution class
    """
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """

        """
            First reach correct head
        """
        while head is not None and head.val == val:
            temp = head
            head = head.next
            temp.next = None
            del temp

        current = head
        while current is not None and current.next is not None:
            if current.next.val == val:
                temp = current.next
                current.next = temp.next
                temp.next = None
                del temp

            else:
                current = current.next

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
        demo solution
    """
    solution = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    head = solution.removeElements(head, 1)
    printlist(head)

if __name__ == '__main__':
    main()