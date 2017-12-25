// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

/* O(NlogK) time complexity */
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
//         for (int n: nums) {
//             if (minHeap.size() < k || n > minHeap.peek()) {
//                 minHeap.offer(n);
//                 if (minHeap.size() > k)
//                     minHeap.poll();
//             }
//         }
//         return minHeap.poll();
//     }
// }


// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// quickselect O(n) time complexity with randomized pivot selection
// Worst case O(n^2) time complexity
class Solution {
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // end is inclusive
    private int findKthLargest(int []nums, int start, int end, int k) {
        if (start == end)
            return start;   // single element
        
        int mid = (start + end) / 2;
        swap(nums, mid, end);
        
        int l = start, r = end - 1;
        while (l <= r) {
            while (l <= r && nums[l] <= nums[end])
                l++;
            while (l <= r && nums[r] > nums[end])
                r--;
            if (l < r)
                swap(nums, l, r);
        }
        swap(nums, l, end);
        int p = end - l + 1;
        if (p == k)
            return l;
        else if (p > k)
            return findKthLargest(nums, l + 1, end, k);
        else
            return findKthLargest(nums, start, l - 1, k - p);
    }
    
    public int findKthLargest(int[] nums, int k) {
        int idx = findKthLargest(nums, 0, nums.length - 1, k);
        return nums[idx];
    }
}