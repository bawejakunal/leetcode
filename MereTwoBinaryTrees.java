// https://leetcode.com/problems/merge-two-binary-trees/

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        // merge current node
        TreeNode cur = new TreeNode(t1.val + t2.val);
        cur.left = mergeTrees(t1.left, t2.left);
        cur.right = mergeTrees(t1.right, t2.right);
        return cur;
    }
}