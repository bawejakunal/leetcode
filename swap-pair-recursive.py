"""
    https://leetcode.com/problems/swap-nodes-in-pairs/
    Given a linked list, swap every two adjacent nodes and return its head.
    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Solution class leetcode
    """

    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        """
            recursively swap
        """
        if head is None or head.next is None:
            return head

        # get head or pair swapped linked list from
        # head.next.next
        nextnode = self.swapPairs(head.next.next)
        # swap head and head.next and link to rest of list
        temp = head.next
        temp.next = nextnode
        head.next = temp.next
        temp.next = head
        head = temp
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
        pairwise swap demo
    """
    solution = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    current = head.next.next.next
    current.next = ListNode(5)
    head = solution.swapPairs(head)
    printlist(head)

if __name__ == '__main__':
    main()
