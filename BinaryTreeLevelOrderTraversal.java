/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new LinkedList<List<Integer>>();
        if (root == null) {
            return traversal;
        }
        
        LinkedList<Integer> last;
        LinkedList<TreeNode> nextLevel;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
            nextLevel = new LinkedList<>();
            last = new LinkedList<Integer>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                last.add(node.val);
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }
            if (last.size() > 0) {
                traversal.add(last);
            }
            q.addAll(nextLevel);
        }
        return traversal;
    }
}