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
  ArrayList<Integer> collectLeaves(TreeNode root, ArrayList<Integer> leaf)
    {
        //base case 
        if(root == null) return leaf;
        
        if(root.left == null && root.right == null) leaf.add(root.val);
        
        leaf = collectLeaves(root.left, leaf);
        leaf = collectLeaves(root.right, leaf);
        
        return leaf;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        leaf1 = collectLeaves(root1, leaf1);
        ArrayList<Integer> leaf2 = new ArrayList<>();
        leaf2 = collectLeaves(root2, leaf2);

        return leaf1.equals(leaf2);
}
}