// https://leetcode.com/problems/count-complete-tree-nodes

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
    int height(TreeNode root) {
        int ht = -1;
        TreeNode current = root;
        while (current != null) {
            current = current.left;
            ht++;
        }
        return ht;
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == -1)
            return 0;
        else if (h-1 == height(root.right)) // left subtree complete
            return (1 << h) + countNodes(root.right);
        else
            return (1 << h-1) + countNodes(root.left);    // right tree incomplete
    }
}