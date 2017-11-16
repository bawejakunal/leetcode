// https://leetcode.com/problems/3sum-closest/discuss/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int csum = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);   // nlogn
        
        // O(n2)
        for (int i = 0; i < nums.length - 2; i++) {
            int mid = i + 1, end = nums.length - 1;
            while (mid < end) {
                int sum = nums[i] + nums[mid] + nums[end];
                if (sum > target)
                    end--;
                else
                    mid++;
                
                if (Math.abs(sum - target) < Math.abs(csum - target))
                    csum = sum;
            }
        }
        return csum;
    }
}