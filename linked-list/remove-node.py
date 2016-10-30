"""
    Remove nth node from end of list
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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

    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        length = self.getlen(head)
        if n > length or n < 1:
            """
                invalid n
            """
            return head

        number = length - n
        # delete number + 1 position node
        
        current = head
        if number == 0:
            """
                head is to be deleted
            """
            head = current.next
            current.next = None
            del current

        else:
            while True:
                number -= 1
                if number == 0:
                    break
                current = current.next


            # delete current.next
            temp = current.next
            current.next = current.next.next
            temp.next = None
            del temp

        return head

def printlist(head):
    current = head
    while current is not None:
        print current.val
        current = current.next

def main():
    """
        Sample run
    """
    solution = Solution()
    head = ListNode(1)
    head = solution.removeNthFromEnd(head, 1)
    printlist(head) #no output because only 1 node that is deleted

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head = solution.removeNthFromEnd(head, 2)
    printlist(head) # 1-2-4

if __name__ == '__main__':
    main()
