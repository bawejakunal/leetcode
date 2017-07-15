// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        int countA = 0, countB = 0;
        
        // count nodes in listA
        while (first != null) {
            countA++;
            first = first.next;
        }
        
        // count nodes in listB
        while (second != null) {
            countB++;
            second = second.next;
        }
        
        // reset pointers to head
        first = headA;
        second = headB;
        
        // cover difference of nodes
        while (first != null && countA > countB) {
            first = first.next;
            countA--;
        }
        while (second != null && countB > countA) {
            second = second.next;
            countB--;
        }
        
        // move together 1 pace ahead
        while (first != null && second != null && first != second) {
            first = first.next;
            second = second.next;
        }
        return first == null ? null : second;
    }
}