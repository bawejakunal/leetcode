// https://leetcode.com/problems/print-binary-tree/description/

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
    
    public List<List<String>> printTree(TreeNode root) {
    
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr,"");
        
        List<List<String>> ans = new ArrayList<>();
        
        fillMatrix(res, root, 0, 0, res[0].length);
        
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        
        return ans;
    }
    
    public void fillMatrix(String[][] res, TreeNode root, int level, int left, int right) {
        if (root == null)
            return;
        res[level][(left + right) / 2] = ""+ root.val;  // middle element
        fillMatrix(res, root.left, level + 1, left, (left + right) / 2);
        fillMatrix(res, root.right, level + 1, (left + right + 1) / 2, right);
    }
    
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}