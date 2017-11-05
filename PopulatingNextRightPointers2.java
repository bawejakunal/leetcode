// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeLinkNode first = q.poll();
                if (i < n - 1)  // till penultimate node of given level
                    first.next = q.peek();
                if (first.left != null)
                    q.offer(first.left);
                if (first.right != null)
                    q.offer(first.right);
            }
        }
        return;
    }
}