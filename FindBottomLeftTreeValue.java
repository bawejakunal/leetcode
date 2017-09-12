/**
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        ArrayList<TreeNode> prevLevel = null;
        while (currentLevel.size() > 0) {
            prevLevel = currentLevel;
            currentLevel = new ArrayList<TreeNode>();
            for (TreeNode node: prevLevel) {
                if (node.left != null)
                    currentLevel.add(node.left);
                if (node.right != null)
                    currentLevel.add(node.right);
            }
        }
        return prevLevel.get(0).val;
    }
}