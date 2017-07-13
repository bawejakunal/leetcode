// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<Double>();
        if (root == null)
            return averages;
        int nodes = 1;  // nodes on level
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);    // add root element
        while(queue.peek() != null) {
            int cnt = 0;
            int nextLevel = 0;
            Double avg = 0.0;
            // traverse complete level
            while (nodes-- > 0) {
                TreeNode current = queue.poll();
                cnt++;
                avg += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                    nextLevel++;
                }
                if (current.right != null) {
                    queue.add(current.right);
                    nextLevel++;
                }
            }
            
            // level avg
            avg /= cnt;
            averages.add(avg);
            
            // next level;
            nodes = nextLevel;
        }
        return averages;
    }
}