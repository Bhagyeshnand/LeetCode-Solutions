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
        ListNode first = l1;
        ListNode second = l2;
        ListNode res = new ListNode();
        ListNode returned = res;
        int modul = 0;
        int sum=0;
        while(first!=null || second!=null){
            sum = modul;
            if(first!=null){
                sum+= first.val;
                first = first.next;
            }
            if(second!=null){
                sum+= second.val;
                second = second.next;
            }
            res.next = new ListNode(sum % 10);
            res = res.next;
            modul = sum/10;
        }
        if(modul!=0){
            res.next = new ListNode(modul);
        }
        return returned.next;
    }
}