// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new LinkedList<Integer>();
        
        if (root == null)
            return maxValues;
        
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            
            int levelMax = currentLevel.peek().val;
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            
            while (!currentLevel.isEmpty()) {
                TreeNode nextNode = currentLevel.poll();
                levelMax = Math.max(levelMax, nextNode.val);
                if (nextNode.left != null)
                    nextLevel.add(nextNode.left);
                if (nextNode.right != null)
                    nextLevel.add(nextNode.right);
            }
            
            maxValues.add(levelMax);
            currentLevel = nextLevel;
        }
        return maxValues;
    }
}