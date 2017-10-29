// https://leetcode.com/problems/subsets/description/

class Solution {
    
    private void findAllSubset(int idx, int[] nums, List<List<Integer>> allSet) {
        if (idx >= nums.length)
            allSet.add(new ArrayList<Integer>());
        else {
            findAllSubset(idx + 1,  nums, allSet);
            int maxCount = allSet.size();
            for (int i = 0; i < maxCount; i++) {
                List<Integer> copy = new ArrayList<Integer>(allSet.get(i));   // add for each set already present
                copy.add(nums[idx]);
                allSet.add(copy);
            }
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSet = new ArrayList<List<Integer>>();
        findAllSubset(0, nums, allSet);
        return allSet;
    }
}