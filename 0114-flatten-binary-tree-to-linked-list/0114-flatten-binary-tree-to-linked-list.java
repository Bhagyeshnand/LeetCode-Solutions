public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Process right subtree first
        flatten(root.right);

        // Process left subtree
        flatten(root.left);

        // Set the current node's right to prev and left to null
        root.right = prev;
        root.left = null;

        // Update prev to current node
        prev = root;
    }
}