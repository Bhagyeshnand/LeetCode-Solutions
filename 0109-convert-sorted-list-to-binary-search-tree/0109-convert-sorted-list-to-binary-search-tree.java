class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow=head,fast=head,slow_Prev=null;
        while(fast!=null && fast.next!=null){
            slow_Prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);//Making A Root Node
        slow_Prev.next = null;//Braeking The Link For L1
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}