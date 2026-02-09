/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return Build_BST(0, res.size() - 1);
    }

    public void inorder(TreeNode root ){
         if(root == null) return;
         inorder(root.left);
         res.add(root);
         inorder(root.right);
    }
    
    public TreeNode Build_BST( int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = res.get(mid);
        node.left = Build_BST( start, mid - 1);
        node.right = Build_BST( mid + 1, end);
        return node;
    }
}