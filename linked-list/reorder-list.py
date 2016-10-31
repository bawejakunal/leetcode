"""
    https://leetcode.com/problems/reorder-list/
    You must do this in-place without altering the nodes' values.
    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
        Solution class leetcode
    """
    def reorderList(self, head):
        if not head:
            return
            
        # find the mid point
        slow = fast = head 
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half in-place
        pre, node = None, slow
        while node:
            pre, node.next, node = node, pre, node.next
        
        # Merge in-place; Note : the last node of "first" and "second" are the same
        first, second = head, pre
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
        return 

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
        demo concept
    """
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    solution = Solution()
    solution.reorderList(head)
    printlist(head)

if __name__ == '__main__':
    main()
