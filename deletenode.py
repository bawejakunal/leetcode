"""
    Write a function to delete a node (except the tail) in a singly linked
    list, given only access to that node.
    https://leetcode.com/problems/delete-node-in-a-linked-list/
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    """
        leetcode solution class
    """
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        if node is None or node.next is None:
            return

        temp = node.next
        node.val = temp.val
        node.next = temp.next
        temp.next = None
        del temp

#TODO: Write main method for demo
