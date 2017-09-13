// https://leetcode.com/problems/most-frequent-subtree-sum/description/

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
    
    private int subTreeSum(TreeNode root, HashMap<Integer, Integer> frequency) {
        if (root == null)
            return 0;
        
        int sum = root.val;
        sum += subTreeSum(root.left, frequency);
        sum += subTreeSum(root.right, frequency);
        
        frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
        return sum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        subTreeSum(root, frequency);
        
        int maxFreq = 0;
        for (Integer value: frequency.values())
            maxFreq = Math.max(maxFreq, value.intValue());
        
        ArrayList<Integer> sumList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFreq)
                sumList.add(entry.getKey());
        }
        
        int[] ans = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++)
            ans[i] = sumList.get(i);
        return ans;
    }
}