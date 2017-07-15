// https://leetcode.com/problems/binary-tree-tilt/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Tuple {
    int sum;
    int tilt;
    Tuple () {
        this.sum = 0;
        this.tilt = 0;
    };
    Tuple (int sum, int tilt) {
        this.sum = sum;
        this.tilt = tilt;
    }
}


public class Solution {
    
    private Tuple sumTree (TreeNode root) {
        if (root == null)
            return new Tuple(0, 0); // null tree
        Tuple leftTilt = sumTree(root.left);
        Tuple rightTilt = sumTree(root.right);
        Tuple nodeTilt = new Tuple();
        nodeTilt.sum = leftTilt.sum + rightTilt.sum + root.val;
        nodeTilt.tilt = Math.abs(leftTilt.sum - rightTilt.sum);
        nodeTilt.tilt += leftTilt.tilt + rightTilt.tilt;
        return nodeTilt;
    }
    
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        Tuple rootTilt = sumTree(root);
        return rootTilt.tilt;
    }
}