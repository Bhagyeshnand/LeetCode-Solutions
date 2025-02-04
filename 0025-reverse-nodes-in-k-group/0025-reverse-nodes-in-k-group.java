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
    public ListNode getKthNode(ListNode head,int k){
        while(--k!=0&&head!=null)
        {
            head=head.next;
        }
        return head;
    }
    public ListNode inPlaceReverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kNode = getKthNode(head,k);
        if(kNode==null) return head;
        ListNode res = kNode;
        ListNode prev = null;
        while(kNode!=null){
            ListNode nextToKNode = kNode.next;
            kNode.next = null;
            ListNode reverseNodeGroup = inPlaceReverse(head);
            if(prev!=null) prev.next = reverseNodeGroup; // head attachment.
            head.next = nextToKNode; // tail attachment.

            prev = head; // current tail becomes prev
            head = nextToKNode; // next to Kth node becomes next head.
            kNode = getKthNode(head,k); // update the Kth node.
        }
        return res;
    }
}