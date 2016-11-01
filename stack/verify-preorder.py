"""
    I did not subscribe to leetcode so writing a generic solution
    https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
"""

"""
    Assume you are given a pre-order traversal of a binary search tree in the
    form of an array. You have to verify whether that is a valid pre-order traversal or not.
"""

def verify_preorder(traversal):
    """
        verify correctness of preorder
    """
    stack = list()
    status = True
    root = None
    for node in traversal:
        if root is not None and node < root:
            status = False
            break

        while len(stack) > 0 and stack[-1] < node:
            root = stack.pop()
        stack.append(node)

    return status

def main():
    """
        Demo verify
    """
    print verify_preorder([40, 30, 35, 20, 80, 100])
    print verify_preorder([2, 1, 3])

if __name__ == '__main__':
    main()
