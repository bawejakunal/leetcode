// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    
    int findPivot(int []nums, int start, int end) {
        if (nums == null || start >= end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1])
                return mid;
        int left = findPivot(nums, start, mid);
        if (left == -1) {
            return findPivot(nums, mid + 1, end);
        }
        return left;
    }
    
    private int binarySearch(int []nums, int start, int end, int target) {
        if (nums == null || start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return binarySearch(nums, mid + 1, end, target);
        else 
            return binarySearch(nums, start, mid - 1, target);
    }
    
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        int left = binarySearch(nums, 0, pivot, target);
        if (left == -1)
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        return left;
    }
}