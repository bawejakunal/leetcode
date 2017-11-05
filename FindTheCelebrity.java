/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
// https://leetcode.com/problems/find-the-celebrity/description/


public class Solution extends Relation {
    
    private HashMap<String, Boolean> cache = new HashMap<>();
    
    // cache results to minimize api calls
    private boolean cknows(int i, int j) {
        String key = i + "," + j;
        if (this.cache.containsKey(key))
            return this.cache.get(key);
        Boolean ans = knows(i, j);
        this.cache.put(key, ans);
        return ans.booleanValue();
    }
    
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean possible = true;
            for (int j = 0; j < n && possible; j++) {
                if (i == j)
                    continue;
                // not a celebrity if i knows j
                possible = !cknows(i, j);
            }
            if (possible) {
                for (int j = 0; j < n && possible; j++) {
                    if (i == j)
                        continue;
                    possible = cknows(j, i);
                }
                if (possible)
                    return i;
            }
        }
        return -1;
    }
}