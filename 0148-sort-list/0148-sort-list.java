class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return quickSort(head);
    }

    private ListNode quickSort(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode stop) {
        if (head == null || head.next == null || head == stop || head.next == stop) {
            return head;
        }
        ListNode lowHead = head;
        ListNode prev = head;
        ListNode tail = prev.next;
        boolean isSorted = true;
        while (tail != stop) {
            isSorted = isSorted && prev.val <= tail.val;
            if (tail.val < head.val) {
                prev.next = tail.next;
                tail.next = lowHead;
                lowHead = tail;
            } else {
                prev = prev.next;
            }
            tail = prev.next;
        }

        if (isSorted) {
            return head;
        }

        ListNode result = quickSort(lowHead, head);

        head.next = quickSort(head.next, stop);

        return result;
    }
}