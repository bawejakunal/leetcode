// https://leetcode.com/problems/random-pick-index/discuss/

class Solution {

    private int[]nums;
    private Random rnd;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    // reservoir of size 
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rnd.nextInt(++count) < 1)
                    result = i;
            }
        }
        return result;
    }

    // reservoir of size 1
    public int pickNext() {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (rnd.nextInt(i) < 1)
                result = i;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */