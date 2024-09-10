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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if( head.next == null) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while( node2 != null){
            int gcd = GCD(node1.val , node2.val);
            ListNode mid = new ListNode(gcd);

            node1.next = mid;
            mid.next = node2;

            node1 = node2;
            node2 = node2.next;
        }

        return head;

    }

    private int GCD (int a, int b){
           if (b == 0) return a;
           else return GCD(b, a % b);
        }
}