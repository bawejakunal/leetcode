// https://leetcode.com/problems/maximum-length-of-pair-chain/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int []p1, int []p2) {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        
        int []prev = pairs[0];
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prev[1]) {
                prev = pairs[i];
                count++;
            }
        }
        return count;
    }
}
