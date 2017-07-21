// https://leetcode.com/problems/subtree-of-another-tree/#/solution

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
    
    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean same = equal(s, t);
        if (!same)
            same = (s.left !=null && isSubtree(s.left, t)) || (s.right != null && isSubtree(s.right, t));
        return same;
    }
}