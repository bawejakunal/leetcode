// https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        // sort the array
        Arrays.sort(nums);
        
        // for each first of a triplet
        for (int f = 0; f < nums.length - 2; f++) {
            // choose next unique first
            if (f == 0 || f > 0 && nums[f] != nums[f-1]) {
                // two pointers on following numbers
                int l = f + 1;
                int r = nums.length - 1;
                
                // check all valid combinations
                while (l < r) {
                    int sum = nums[f] + nums[l] + nums[r];
                    // triplet found
                    if (sum == 0) {
                        // add to set
                        triplets.add(Arrays.asList(nums[f], nums[l], nums[r]));
                        // ensure unique
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        // ensure unique
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    }
                    else if (sum < 0)
                        l++;    // sum was smaller, try with larger middle number
                    else
                        r--;    // sum was greater, try with smaller largest number of triplet
                }
            }
        }
        return triplets;
    }
}