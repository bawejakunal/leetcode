// https://leetcode.com/problems/combination-sum-iii/discuss/

class Solution {
    
    private void findCombination(List<List<Integer>> ans, List<Integer> combination, int s, int k, int n) {
        if (combination.size() == k && n == 0) {
            List<Integer> c = new ArrayList<Integer>(combination);  // copy combination
            ans.add(c);                                             // add possible combination
        }
        else if (k > 0 && n > 0 && s <= n) {
            for (int i = s; i <= 9; i++) {
                combination.add(i);
                findCombination(ans, combination, i + 1, k, n - i);
                combination.remove(combination.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        findCombination(ans, new ArrayList<Integer>(), 1, k, n);
        return ans;
    }
}