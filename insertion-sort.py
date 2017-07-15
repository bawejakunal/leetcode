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
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head

        nextnode = self.insertionSortList(head.next)
        head.next = nextnode
        current = head
        while current.next is not None and current.next.val < head.val:
            current = current.next

        if current is not head:
            head.next = current.next
            current.next = head
            head = nextnode

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
    head = solution.insertionSortList(head)
    printlist(head)

    print '------------'

    head = ListNode(3)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    head.next.next.next = ListNode(4)
    head = solution.insertionSortList(head)
    printlist(head)

if __name__ == '__main__':
    main()
