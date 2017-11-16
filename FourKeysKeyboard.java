// https://leetcode.com/problems/4-keys-keyboard/discuss/

class Solution {
    public int maxA(int N) {
        int []count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            count[i] = i;   // atleast i times A can be typed
            for (int j = 1; j <= i - 3; j++)
                // ctrl-a,c and ctrl-v for i - j - 2 times gives i - j - 1 copies of count[j]
                count[i] = Math.max(count[i], count[j] * (i - j - 1));
        }
        return count[N];
    }
}