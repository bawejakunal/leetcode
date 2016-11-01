# Definition for a  binary tree node
class TreeNode(object):
    """
        TreeNode definition
    """
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        """
            construct inorder list
        """
        self.inorder = list()
        stack = list()
        current = root
        while current is not None or len(stack) > 0:
            if current is not None:
                stack.append(current)
                current = current.left
            
            else:
                parent = stack.pop()
                self.inorder.append(parent.val)
                current = parent.right

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.inorder) > 0

    def next(self):
        """
        :rtype: int
        """
        next_element = self.inorder[0]
        del self.inorder[0]
        return next_element

def main():
    """
        main method
    """
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    inorder = list()
    iterator = BSTIterator(root)
    while iterator.hasNext():
        inorder.append(iterator.next())
    print inorder

if __name__ == '__main__':
    main()
