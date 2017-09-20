// https://leetcode.com/problems/shuffle-an-array/discuss/

class Solution {

    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    private void swap(int []nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] =t;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int []cpy = nums.clone();
         for(int i = 0; i < cpy.length; i++) {
            int j = random.nextInt(i + 1);
            swap(cpy, i, j);
        }
        return cpy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */