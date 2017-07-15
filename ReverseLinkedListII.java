// https://leetcode.com/problems/reverse-linked-list-ii

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mPrior, nPost, tHead, tTail, tmp = null, prev;
        int i;
        
        // get to 1 before mth node
        i = 0;
        mPrior = null;
        while (i < m-1) {
            i++;
            if (mPrior == null)
                mPrior = head;
            else
                mPrior = mPrior.next;
        }
        
        // current head of m-n section
        tHead = mPrior!=null ? mPrior.next : head;
        tTail = tHead;  // tTail remains fixed here
        prev = null;
        while (i < n && tHead != null) {
            i++;
            tmp = tHead.next;
            tHead.next = prev;
            prev = tHead;
            tHead = tmp;
        }
        tTail.next = tHead;
        if (mPrior != null)
            mPrior.next = prev;
        
        return mPrior != null ? head: prev;
    }
}