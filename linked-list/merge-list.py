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
        head1 = l1
        head2 = l2
        merged = None

        if head1 is None:
            merged = head2

        elif head2 is None:
            merged = head1

        else:
            if head1.val < head2.val:
                merged = head1
                head1 = head1.next

            else:
                merged = head2
                head2 = head2.next

            tail = merged
            while head1 is not None and head2 is not None:
                if head1.val < head2.val:
                    tail.next = head1
                    head1 = head1.next

                else:
                    tail.next = head2
                    head2 = head2.next

                tail = tail.next

            if head1 is not None:
                tail.next = head1

            elif head2 is not None:
                tail.next = head2

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