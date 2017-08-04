// https://leetcode.com/problems/balanced-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int height(TreeNode root) {
        if (root == null)   // null node
            return 0;
        int left = height(root.left);
        if (left == -1) // left unbalanced
            return -1;
        int right = height(root.right);
        if (right == -1)    // right unbalanced
            return -1;
        if (Math.abs(left - right) > 1) // unbalance
            return -1;
        return 1 + Math.max(left, right);   // balanced, increment height by 1
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return -1 < height(root);
    }
}