"""
    Merge sorted lists
    https://leetcode.com/problems/merge-two-sorted-lists/
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Leetcode Solution class
    """
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        merged = None
        current = None
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                if current is not None:
                    current.next = l1
                    current = current.next
                else:
                    current = l1
                    merged = current
                l1 = l1.next
            else:
                if current is not None:
                    current.next = l2
                    current = current.next
                else:
                    current = l2
                    merged = current
                l2 = l2.next

        if l1 is not None:
            if current is None:
                merged = l1
            else:
                current.next = l1

        elif l2 is not None:
            if current is None:
                merged = l2
            else:
                current.next = l2

        return merged

def printlist(head):
    current = head
    while current is not None:
        print current.val
        current = current.next

def main():
    """
        main method
    """
    h1 = ListNode(1)
    h1.next = ListNode(2)
    h1.next.next = ListNode(8)

    h2 = ListNode(3)
    h2.next = ListNode(4)
    h2.next.next = ListNode(9)

    solution = Solution()
    merged = solution.mergeTwoLists(h1, h2)
    printlist(merged)

if __name__ == '__main__':
    main()