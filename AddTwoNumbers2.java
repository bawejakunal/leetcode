// https://leetcode.com/problems/add-two-numbers-ii/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int addLists(ListNode h1, ListNode h2) {
        if (h1 == null && h2 == null)
            return 0;
        int carry = addLists(h1.next, h2.next);
        int sum = h1.val + h2.val + carry;
        h1.val = sum % 10;  // save ones digit on longer list
        return sum / 10;    // return carry digit up the stack
    }
    
    private int length(ListNode l) {
        if (l == null)
            return 0;
        return 1 + length(l.next);
    }
    
    private int addToList(ListNode l, int depth, int number) {
        if (l == null || depth == 0)
            return number;
        int carry = addToList(l.next, depth - 1, number);
        int sum = l.val + carry;
        l.val = sum % 10;
        return sum / 10;    // return carry
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode longer = l1;
        ListNode shorter = l2;
        int diff = length(l1) - length(l2);
        if (diff < 0) {
            diff *= -1;
            longer = l2;
            shorter = l1;
        }
        ListNode head = longer;
        for (int i = 0; i < diff; i++) {
            head = head.next;
        }
        int carry = addLists(head, shorter);    // equal this point onwards
        if (carry > 0) {
            carry = addToList(longer, diff, carry);
            while (carry > 0) {
                ListNode newHead = new ListNode(carry % 10);
                carry /= 10;
                newHead.next = longer;
                longer = newHead;
            }
        }
        return longer;
    }
}