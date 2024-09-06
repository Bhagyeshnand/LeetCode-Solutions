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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet <Integer> set = new HashSet<>();
        for(int e : nums) { set.add(e);}

        while(set.contains(head.val) && head != null){ // handling the head condition
           head = head.next;
        }

        ListNode curr = head;
        while( curr != null && curr.next != null ){
            if(set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            else{
            curr = curr.next;
            }      
        }

        return head;
    }
}