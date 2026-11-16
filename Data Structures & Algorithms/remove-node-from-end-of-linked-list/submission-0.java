/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode preOfCur = head;

        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        while (pre != null) {
            pre = pre.next;
            preOfCur = cur;
            cur = cur.next;
        }

        if (cur == preOfCur) {
            head = cur.next;
        } else {
            preOfCur.next = cur.next;
        }

        return head;
    }
}