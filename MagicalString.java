// https://leetcode.com/problems/magical-string/description/

class Solution {
    public int magicalString(int n) {
        
        if (n < 1)
            return 0;
        if (n <= 3)
            return 1;
        
        int generated = 3;
        int countOne = 1;
        int toGen = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(2);
        
        while (generated < n) {
            int count = q.poll();
            while (count-- > 0) {
                q.add(toGen);
                countOne += toGen == 1 ? 1 : 0;
                if (++generated == n)
                    break;
            }
            toGen ^= 3; // flip between 1 and 2
        }
        return countOne;
    }
}