class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: If the list is empty or has only one node
        if(head == null || head.next == null) return head;
        
        // Step 1: Find the length of the linked list
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Calculate the effective rotation using modulo
        int rotation = k % length;

        // Step 3: Perform the rotation for 'rotation' times
        for(int i = 0; i < rotation; i++) {
            ListNode last = head, prev = null;
            
            // Step 4: Traverse the list to find the last node
            while(last.next != null) {
                prev = last;
                last = last.next;
            }
            
            // Step 5: Perform the rotation by adjusting pointers
            last.next = head;
            prev.next = null;
            head = last;
        }
        
        return head;
    }
}