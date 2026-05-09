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
        return addNumHelper(l1, l2, 0);
    }

    public ListNode addNumHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int newCarry = (v1 + v2 + carry) > 9 ? 1 : 0;
            int newVal = (v1 + v2 + carry) % 10;
            ListNode newNode = new ListNode(newVal);
            newNode.next =
                addNumHelper(l1 != null ? l1.next : null, l2 != null ? l2.next : null, newCarry);
            return newNode;
        } else {
            return null;
        }
    }
}
