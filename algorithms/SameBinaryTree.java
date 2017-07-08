/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode.com/problems/same-tree/

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        boolean same = p == null && q == null;                  // both null
        if (same == false)
            same = p != null && q != null && p.val == q.val;    // non null        
        if (same && p != null) {
            same = isSameTree(p.left, q.left);
            if (same == true)
                same = isSameTree(p.right, q.right);
        }
        return same;
    }
}