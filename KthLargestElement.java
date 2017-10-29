// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int n: nums) {
            minHeap.offer(n);
            while (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.poll();
    }
}