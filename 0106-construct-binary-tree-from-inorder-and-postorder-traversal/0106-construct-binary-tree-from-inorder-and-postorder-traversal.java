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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return buildTree(postorder, inorder, 0, n-1, n-1);
    }
    public TreeNode buildTree(int[] postorder, int[] inorder, int l, int r, int p){
        if(p<0 || l>r)
            return null;
        TreeNode root = new TreeNode(postorder[p]);
        int i=indexOf(inorder, l, r, postorder[p]);
        root.right=buildTree(postorder, inorder, i+1, r, p-1);
        root.left=buildTree(postorder, inorder, l, i-1, p-1-r+i);
        return root;
    }
    public int indexOf(int[] inorder, int l, int r, int elm){
        while(l<=r){
            if(inorder[l]==elm)
                return l;
            else if(inorder[r]==elm)
                return r;
            l++;
            r--;
        }
        return -1;
    }
}