// https://leetcode.com/problems/next-greater-element-ii

public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = (2 * nums.length) - 1; i >= 0; i--) {
            // discard the smaller elements
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            
            // mark next greater element
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);    // push on top of stack
        }
        return res;
    }
}
