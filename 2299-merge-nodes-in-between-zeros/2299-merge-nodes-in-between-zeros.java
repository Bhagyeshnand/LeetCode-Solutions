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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode l = new ListNode();
        ListNode t = l;
        int sum;

        while( temp != null && temp.next != null){
        
            if(temp.val == 0){
                sum = 0;
                
                while(temp.next.val > 0 && temp != null && temp.next != null){
                    sum += temp.next.val;
                    temp = temp.next;
                }
                ListNode n = new ListNode(sum);
                t.next = n; 
                t = t.next;
            }
            temp = temp.next;
        }
        return l.next;
    }
}