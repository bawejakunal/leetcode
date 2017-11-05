// https://leetcode.com/problems/subsets-ii/discuss/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> superset = new LinkedList<List<Integer>>();
        superset.add(new ArrayList<Integer>());     //  add empty set
        int size = 0, startIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i-1])
                startIdx = size;    // add duplicates to sets added in previous iteration
            else
                startIdx = 0;
            
            // add nums[i] to clones of all existing set
            size = superset.size();
            for (int j = startIdx; j < size; j++) {
                List<Integer> set = new ArrayList<>(superset.get(j));
                set.add(nums[i]);
                superset.add(set);
            }
        }
        return superset;
    }
}