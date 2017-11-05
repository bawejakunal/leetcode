// https://leetcode.com/problems/h-index/description/

class Solution {
    public int hIndex(int[] citations) {
        int maxH = citations.length;
        int citeCount[] = new int[citations.length + 1];
        for (int c: citations)
            citeCount[Math.min(c, citations.length)]++;
            // citations > citations.length can be replaced by citations.length
        
        for (int p = citeCount[citations.length]; p < maxH;
            p += citeCount[maxH])
            maxH--;
        return maxH;
    }
}