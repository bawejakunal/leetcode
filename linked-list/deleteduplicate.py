"""
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    Given a sorted linked list, delete all duplicates such that each element appear only once.
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Leetcode solution class
    """
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        current = head
        while current is not None and current.next is not None:
            if current.next.val == current.val:
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
        demo method
    """
    solution = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(3)
    head.next.next.next.next = ListNode(3)
    # 1-2-2-3-3
    head = solution.deleteDuplicates(head) 
    # 1-2-3
    printlist(head)

if __name__ == '__main__':
    main()
