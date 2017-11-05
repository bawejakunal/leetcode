// https://leetcode.com/problems/inorder-successor-in-bst/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return root;
        
        // search right subtree of root
        if (root.val <= p.val)
            return inorderSuccessor(root.right, p);
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left == null)
                return root;
            return left;
        }
    }
}