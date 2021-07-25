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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            int number = l1.val + l2.val + carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int number = l1.val + carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int number = l2.val + carry;
            carry = number / 10;
            ListNode node = new ListNode(number % 10);
            pre.next = node;
            pre = pre.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        return head.next;
    }
}