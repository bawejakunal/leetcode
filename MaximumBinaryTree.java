// https://leetcode.com/problems/maximum-binary-tree/description/

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
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(nums, start, maxIdx-1);
        root.right = constructMaximumBinaryTree(nums, maxIdx+1, end);
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
}