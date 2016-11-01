"""
    https://leetcode.com/problems/binary-tree-inorder-traversal/
    Iteratively print inorder traversal of binary tree
    Recursive is trivial
"""
# Definition for a binary tree node.
class TreeNode(object):
    """
        TreeNode definition
    """
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    """
        Leetcode annoying Solution class
    """
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack = list()
        current = root
        inorder = list()
        """
            when current is None and stack empty
            traversal ends as it signals rightmost
            tree
        """
        while current is not None or len(stack) > 0:
            """
                go down the left branch until leaf node
                is reached
            """
            if current is not None:
                stack.append(current)
                current = current.left

            else:
                # add parent of current to inorder
                parent = stack.pop()
                inorder.append(parent.val)
                # right subtree of parent of current
                current = parent.right

        return inorder

def main():
    """
        demo inorder iterative printing
    """
    solution = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    inorder = solution.inorderTraversal(root)
    print inorder

if __name__ == '__main__':
    main()
