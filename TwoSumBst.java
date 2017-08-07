// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    
    private boolean compExists(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;
        else if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return compExists(root.left, k, set) || compExists(root.right, k, set);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return compExists(root, k, set);
    }
}