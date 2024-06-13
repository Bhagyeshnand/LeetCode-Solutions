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
    public ListNode oddEvenList(ListNode head) {
        // If the list is empty or has only one node, return the head as it is.
        if (head == null || head.next == null) {
            return head;
        }
    
        // Initialize pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        // Save the start of the even nodes to connect later
        ListNode evenHead = head.next;

        // Iterate through the list to rearrange nodes
        while (odd.next != null && even.next != null) {
            // Link the current odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Link the current even node to the next even node
            even.next = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the head of even nodes
        odd.next = evenHead;

        // Return the restructured list
        return head;
    }
}