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
         if(root == null)
            return null;
        
        if(root.val == p.val || root.val == q.val) //if p or q = root then they are LCA
            return root;
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if(l != null && r != null)  // we got our left and right nodes so root is LCA
            return root;
        
        return l !=null ? l : r; //IF any one of p,q is found return it.
    }
}