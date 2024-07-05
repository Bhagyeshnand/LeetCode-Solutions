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
        final int[] result = new int[] { -1, -1 };
        ListNode prev = head, curr = head.next;
        int i = 1, prevM = 0;

        while(curr.next != null) {
            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                if(prevM != 0) {
                    final int diff = i - prevM;

                    if(result[0] == -1) {
                        result[0] = diff;
                        result[1] = diff;
                    } else {
                        result[0] = Math.min(result[0], diff);
                        result[1] += diff;
                    }
                }

                prevM = i;
            }

            i++;
            prev = curr;
            curr = curr.next;
        }

        return result;
    }
}