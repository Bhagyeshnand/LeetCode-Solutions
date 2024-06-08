/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    void copy(Node head){
        Node temp = head, n = head.next;
        while(temp!= null){
            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = n;
            temp= n;
            if(n!=null) n= n.next;
        }
    }
    void Rand(Node head){
        Node temp = head;
        while(temp!= null)
        {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp= temp.next.next;
        }
    }
    Node detach(Node head){
        Node dummy = new Node(-1);
        Node tail = dummy, temp = head;
        while(temp!=null)
        {
            tail.next = temp.next;
            tail = tail.next;
            temp.next = tail.next;
            temp= temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        copy(head);
        Rand(head);
        return detach(head);
    }
}