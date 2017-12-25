// https://leetcode.com/problems/wiggle-subsequence/description/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int []up = new int[nums.length];
        int []down = new int[nums.length];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
                else if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return Math.max(up[nums.length-1], down[nums.length-1]);
    }
}

// https://leetcode.com/problems/wiggle-subsequence/description/

// public class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         if (nums.length < 2)
//             return nums.length;
//         int down = 1, up = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > nums[i - 1])  
//                 up = down + 1;
//             else if (nums[i] < nums[i - 1])
//                 down = up + 1;
//         }
//         return Math.max(down, up);
//     }
// }