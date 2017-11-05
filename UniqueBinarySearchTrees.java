// https://leetcode.com/problems/unique-binary-search-trees/description/

class Solution {
    
    public int numTrees(int n, int[] counts) {
        if (counts[n] > 0)
            return counts[n];
        
        int count = 0;
        for (int r = 1; r <= n; r++) {
            count += numTrees(r-1, counts) * numTrees(n-r, counts); // left * right trees
        }
        counts[n] = count;
        return count;
    }
    
    public int numTrees(int n) {
        int []counts = new int[n+1];
        counts[0] = 1;
        return numTrees(n, counts);
    }
}