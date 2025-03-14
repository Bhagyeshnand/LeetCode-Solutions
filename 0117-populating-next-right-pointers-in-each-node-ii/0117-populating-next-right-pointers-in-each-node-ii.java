/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node cur=root;
        while(cur!=null){
            Node nxt=new Node(0);//nxt node not connected to tree initially
            Node temp=nxt;//we need a pointer to maintain level and another for traversing in that level
            while(cur!=null){
                if(cur.left!=null){
                    temp.next=cur.left;
                    temp=temp.next;
                }
                if(cur.right!=null){
                    temp.next=cur.right;
                    temp=temp.next;
                }
                cur=cur.next;//traverse in breadth
            }
            cur=nxt.next;//go to next level using nxt pointer
        }
        return root;
        
    }
}