// https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new LinkedList<String>();
        List<String> left = binaryTreePaths(root.left);
        left.addAll(binaryTreePaths(root.right));   // add right sub tree paths
        if (left.size() == 0)
            left.add(Integer.toString(root.val));
        else {
            for(ListIterator<String> iter = left.listIterator(); iter.hasNext();) {
                String e = iter.next();
                iter.set(Integer.toString(root.val) + "->" + e);
            }
        }
        return left;
    }
}