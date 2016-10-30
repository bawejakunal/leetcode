"""
    https://leetcode.com/problems/linked-list-cycle/
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
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        fast = None
        slow = None
        
        # flag = False assumes no cycle
        flag = False

        if head is not None:
            slow = head.next
            if slow is not None:
                fast = slow.next
 
            while fast is not None and slow is not None:
                # check if fast caught up with slow
                if slow is fast:
                    flag = True
                    break
                # increment slow by one
                slow = slow.next

                # increment fast by two
                fast = fast.next
                if fast is not None:
                    fast = fast.next

        return flag

def main():
    """
        Main Method for cycle detection
    """
    head = ListNode(1)
    head.next = head # point to itself to create a cycle
    solution = Solution()
    print solution.hasCycle(head)

    nextnode = ListNode(2)
    head.next = nextnode
    # Now list looks like 1->2
    print solution.hasCycle(head)


if __name__ == '__main__':
    main()
