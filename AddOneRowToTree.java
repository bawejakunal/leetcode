// https://leetcode.com/problems/add-one-row-to-tree/description/

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // insert at root level
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            root = node;
        }
        else if (d == 2 && root != null) {
            TreeNode leftChild = new TreeNode(v);
            TreeNode rightChild = new TreeNode(v);
            leftChild.left = root.left;
            rightChild.right = root.right;
            root.left = leftChild;
            root.right = rightChild;
        }
        else if (root != null) {
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
        }
        return root;
    }
}