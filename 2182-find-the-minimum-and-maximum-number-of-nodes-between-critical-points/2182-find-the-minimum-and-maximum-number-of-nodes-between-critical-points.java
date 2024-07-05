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
    public int[] nodesBetweenCriticalPoints(final ListNode head) {
        final int[] result = new int[] { -1, -1 }; // Initialize result array with -1
        ListNode prev = head, curr = head.next;    // Initialize prev and curr pointers
        int i = 1, prevM = 0; // Initialize index i and prevM to track previous critical point index

        // Traverse the list while checking for critical points
        while(curr != null && curr.next != null) {
            // Check if current node is a critical point
            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                // If a previous critical point exists, calculate distance
                if(prevM != 0) {
                    final int diff = i - prevM;

                    // Update minimum and maximum distances
                    if(result[0] == -1) {
                        result[0] = diff;
                        result[1] = diff;
                    } else {
                        result[0] = Math.min(result[0], diff);
                        result[1] += diff;
                    }
                }

                // Update the index of the previous critical point
                prevM = i;
            }

            // Move to the next node
            i++;
            prev = curr;
            curr = curr.next;
        }

        return result; // Return the result array
    }
}
