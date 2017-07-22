# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if (root is None or 
            p is root or 
            q is root or
            p.val < root.val < q.val or
            p.val > root.val > q.val):
            return root
        if p.val < root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        return self.lowestCommonAncestor(root.right,p,q)