// https://leetcode.com/problems/third-maximum-number

public class Solution {
    public int thirdMax(int[] nums) {
        Integer max[] = {null, null, null};
        for (Integer n: nums) {
            if (n.equals(max[0]) || n.equals(max[1]) || n.equals(max[2]))
                continue;   // avoid duplicates
            else if (max[2] == null || n > max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = n;
            }
            else if (max[1] == null || n > max[1]) {
                max[0] = max[1];
                max[1] = n;
            }
            else if (max[0] == null || n >= max[0]) {
                max[0] = n;
            }
        }
        if (max[0] == null)    // third max equals max
            max[0] = max[2];
        return max[0];
    }
}