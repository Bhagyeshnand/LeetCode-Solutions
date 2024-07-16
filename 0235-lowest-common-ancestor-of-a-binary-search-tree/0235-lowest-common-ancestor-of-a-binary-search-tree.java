/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;
        
        if(root.val == p.val) return p;
        if(root.val == q.val) return q; 

        TreeNode node = root;

        if(p.val < root.val && q.val < root.val){
            node = lowestCommonAncestor(root.left, p,q);
        }

        if(p.val > root.val && q.val > root.val){
            node = lowestCommonAncestor(root.right, p,q);
        }

        return node;
    }
}