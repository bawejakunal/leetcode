// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode mergeTwo(ListNode first, ListNode second) {
        ListNode head = null, tail = null;
        while (first != null && second != null) {
            if (first.val < second.val) {
                if (head == null) {
                    head = first;
                    tail = head;
                }
                else {
                    tail.next = first;
                    tail = tail.next;
                }
                first = first.next;
            }
            else {
                if (head == null) {
                    head = second;
                    tail = head;
                }
                else {
                    tail.next = second;
                    tail = tail.next;
                }
                second = second.next;
            }
        }
        
        if (first != null) {
            if (head == null)
                head = first;
            else
                tail.next = first;
        }
        
        if (second != null) {
            if (head == null)
                head = second;
            else 
                tail.next = second;
        }
        
        return head;    // merge two lists
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1)
            return null;
        
        
        for (int step = 1; step < total; step <<= 1) {
            for (int i = 0; i < total - step; i += (step << 1))
                lists[i] = mergeTwo(lists[i], lists[i + step]);
        }
        
        return lists[0];
    }
}