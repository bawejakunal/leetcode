// https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> traversal = new LinkedList<List<Integer>>();
        
        if (root != null) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            Queue<TreeNode> nodeQ = new LinkedList<>();
            Queue<Integer> posQ = new LinkedList<>();
            int left = 0;
            int right = 0;
            
            nodeQ.offer(root);
            posQ.offer(0);
        
            while (!nodeQ.isEmpty()) {
                TreeNode node = nodeQ.poll();
                int col = posQ.poll();
                if (!map.containsKey(col))
                    map.put(col, new ArrayList<Integer>());
                map.get(col).add(node.val);

                if (node.left != null) {
                    nodeQ.offer(node.left);
                    posQ.offer(col - 1);
                    left = Math.min(left, col - 1);
                }

                if (node.right != null) {
                    nodeQ.offer(node.right);
                    posQ.offer(col + 1);
                    right = Math.max(right, col + 1);
                }
            }

            for (int key = left; key <= right;key++) {
                traversal.add(map.get(key));
            }
        }
        
        return traversal;
    }
}