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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                runner.next = list1;
                list1 = list1.next;
            } else {
                runner.next = list2;
                list2 = list2.next;
            }
            runner = runner.next;
        }

        if (list1 != null) {
            runner.next = list1;
        } else {
            runner.next = list2;
        }

        return dummy.next;
    }
}