"""
    Write a program to find the node at which the intersection of two singly linked lists begins.
    https://leetcode.com/problems/intersection-of-two-linked-lists/
"""

# Definition for singly-linked list.
class ListNode(object):
    """
        Listnode definition
    """
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    """
        Leetcode Solution class
    """
    def getlen(self, head):
        """
            get length of linked list
        """
        length = 0
        current = head
        while current is not None:
            length += 1
            current = current.next
        return length

    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lengthA = self.getlen(headA)
        lengthB = self.getlen(headB)
        diff = abs(lengthA - lengthB)

        if lengthA > lengthB:
            while diff > 0:
                diff -= 1
                headA = headA.next

        else:
            while diff > 0:
                diff -= 1
                headB = headB.next
        

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headB


def main():
    """
        Intersection demo
    """
    h1 = ListNode(1)
    h1.next = ListNode(2)
    h2 = ListNode(3)
    h2.next = h1.next
    '''
        1---\
             \
             ---2
             /
        3---/
    '''

    solution = Solution()
    intersect = solution.getIntersectionNode(h1, h2)
    if intersect is None:
        print str(None)
    else:
        print intersect.val

    h2.next = ListNode(2)
    '''
        1---2
        
        3---2
    '''
    intersect = solution.getIntersectionNode(h1, h2)
    if intersect is None:
        print str(None)
    else:
        print intersect.val

if __name__ == '__main__':
    main()
