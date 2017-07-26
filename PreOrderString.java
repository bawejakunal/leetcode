// https://leetcode.com/problems/construct-string-from-binary-tree/

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
    
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        
        String val = Integer.toString(t.val);
        if (t.left == null && t.right == null)
            return val;
        
        val += "("+ tree2str(t.left) + ")";
        if (t.right != null)
             val += "(" + tree2str(t.right) + ")";
        return val;
    }
}