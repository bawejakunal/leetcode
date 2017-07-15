// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right && numbers[left] + numbers[right] != target) {
            while (left < right && numbers[left] + numbers[right] < target)
                left++;
            while (left < right && numbers[left] + numbers[right] > target)
                right--;
        }
        return new int[]{left+1, right+1};
    }
}