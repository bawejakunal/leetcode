"""
    https://leetcode.com/problems/palindrome-linked-list/
    Given a singly linked list, determine if it is a palindrome.
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
    def getlen(self, head):
        """
            Get length of linklist
        """
        current = head
        length = 0
        while current is not None:
            length += 1
            current = current.next

        return length

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
        tail.next = None

        return head, tail

    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # Return True for empty or single node linked list
        if head is None or head.next is None:
            return True

        # O(n) time - get length of linked list
        length = self.getlen(head)
        mid = length/2

        # get reference variable to second half of linked list
        second = head
        for i in range(mid):
            second = second.next

        # if odd length linked list adjust reference variable
        if length % 2 == 1:
            second = second.next

        # reverse second half in place O(1) space complexity
        tail = None
        second, tail = self.reverse_util(second, tail)

        # compare first half to second half
        for i in range(mid):
            if head.val != second.val:
                return False
            head = head.next
            second = second.next

        return True


def main():
    """
        Demo: check palindrome singly linked list
    """
    solution = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    print solution.isPalindrome(head)

if __name__ == '__main__':
    main()
