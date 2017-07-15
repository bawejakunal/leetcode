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
    
    private void findPaths(TreeNode root, int sum, List<List<Integer>> pathList,
                      List<Integer> path) {
        if (root==null)
            return;
        // add to current path
        path.add(root.val);
        
        // if path complete
        if (sum == root.val && root.left == null && root.right == null) {
            pathList.add(new LinkedList<Integer>(path));
            // search space for further search
            path.remove(path.size()-1); // remove current subtree from
            return;
        }
        
        findPaths(root.left, sum-root.val, pathList, path);
        findPaths(root.right, sum-root.val, pathList, path);
        
        // after this point remove current subtree from 
        // search space for further search
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        findPaths(root, sum, pathList, path);
        return pathList;
    }
}