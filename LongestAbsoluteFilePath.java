// https://leetcode.com/problems/longest-absolute-file-path/description/

class Solution {
    
    public int lengthLongestPath(String input) {

        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;

        for(String s: paths){
            int level = s.lastIndexOf("\t") + 1;    // evel = leading tabs
            // set start length of next level of directory tree
            // if we see a s with filename then stack[level + 1] is incorrectly set
            // but need not worry because it will be reset if we see another directory at
            // same level, otherwise this will be the last level
            stack[level + 1] = stack[level] + s.length() - level + 1;  // + 1 for a forward slash
            // if current path is a file
            if(s.contains(".")) {
                int curLen = stack[level] + s.length() - level; // substract level to account leading tabs
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}