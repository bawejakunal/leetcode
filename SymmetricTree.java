// https://leetcode.com/problems/symmetric-tree

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
    
    private boolean isMirrored(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) &&
            isMirrored(t1.left, t2.right) &&
            isMirrored(t1.right, t2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isMirrored(root, root);
    }
}


/**
 * Iterative BFS Solution *
 *
 */
// public class Solution {
    
//     public boolean isSymmetric(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.add(root);
//         queue.add(root);
//         while(!queue.isEmpty()) {
//             TreeNode t1 = queue.poll();
//             TreeNode t2 = queue.poll();
//             if (t1 == null && t2 == null)
//                 continue;
//             else if (t1 == null || t2 == null)
//                 return false;
//             else if (t1.val != t2.val)
//                 return false;
//             else {
//                 queue.add(t1.left);
//                 queue.add(t2.right);
//                 queue.add(t1.right);
//                 queue.add(t2.left);
//             }
//         }
//         return true;
//     }
// }