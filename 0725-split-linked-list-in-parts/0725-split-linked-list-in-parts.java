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
    public ListNode[] splitListToParts(ListNode head, int k) {

    //  This method splits a linked list into k parts as evenly as possible.
    //  Each part is returned as an array of ListNode objects.
    //  If the list can't be divided evenly, the first few parts will have an extra node.

    // Create an array of size k to hold the split parts
        ListNode[] ans = new ListNode[k];

        // Step 1: Calculate the total size (number of nodes) of the linked list
        int size = 0;
        ListNode curr = head; // Initialize a pointer to traverse the list
        while (curr != null) {
            size++; // Increment size for each node
            curr = curr.next; // Move to the next node
        }

        // Step 2: Determine the base size of each part and the number of "extra" nodes
        int splitSize = size / k; // Base size of each part (when evenly distributed)
        int RemainingNum = size % k; // Extra nodes that can't be evenly distributed

        // Reset the pointer to the head of the list to start splitting
        curr = head;
        ListNode prev = curr; // To track the previous node for breaking the list

        // Step 3: Loop through k times to create k parts
        for (int i = 0; i < k; i++) {
            // Start the current part with the current node
            ListNode newPart = curr;
            int currSize = splitSize; // Default size of the current part

            // If there are remaining nodes, add 1 to the current part's size
            if (RemainingNum > 0) {
                RemainingNum--; // Decrease the count of extra nodes
                currSize++; // Increase the size of this part
            }

            // Step 4: Traverse the nodes for the current part
            int j = 0;
            while (j < currSize) { // Traverse the current part up to its size
                prev = curr; // Keep track of the previous node
                curr = curr.next; // Move to the next node
                j++; // Increment to keep track of how many nodes we've traversed
            }

            // Step 5: Disconnect the current part from the rest of the list
            if (prev != null) prev.next = null; // Break the link after the current part

            // Store the current part's head in the result array
            ans[i] = newPart;
        }

        // Step 6: Return the array of ListNode parts
        return ans;

    }
}