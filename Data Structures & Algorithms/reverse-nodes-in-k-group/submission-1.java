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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to simplify edge cases (like reversing from the head)
        ListNode dummy = new ListNode(0, head);

        // This will always point to the node BEFORE the group we want to reverse
        ListNode groupPrev = dummy;

        while (true) {
            // Find the k-th node from groupPrev (end of the current group)
            ListNode kth = getKthNode(groupPrev, k);

            // If fewer than k nodes remain, we are done
            if (kth == null) {
                break;
            }

            // Node after the k-group (start of next group)
            ListNode groupNext = kth.next;

            // Prepare to reverse: prev starts at groupNext
            ListNode prev = kth.next;

            // Current node to reverse starts at the first node of the group
            ListNode curr = groupPrev.next;

            // Reverse the nodes in the current k-group
            while (curr != groupNext) {
                ListNode temp = curr.next; // store next
                curr.next = prev; // reverse pointer
                prev = curr; // move prev forward
                curr = temp; // move curr forward
            }

            // After reversing:
            // groupPrev.next was the start of the group, now becomes the end
            ListNode temp = groupPrev.next;

            // Connect previous group to the new head of this reversed group
            groupPrev.next = kth;

            // Move groupPrev to the end of the reversed group
            groupPrev = temp;
        }

        // Return the new head (dummy.next)
        return dummy.next;
    }

    // Helper: returns the k-th node from curr (curr.next is considered node 1)
    public ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr; // returns null if fewer than k nodes remain
    }
}
