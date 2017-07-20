// https://leetcode.com/problems/diameter-of-binary-tree/#/description

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
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);
        
        return Math.max(2+lHeight+rHeight, Math.max(lDiameter, rDiameter));
    }
}