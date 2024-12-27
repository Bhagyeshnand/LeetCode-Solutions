class Solution {
    long prev = Long.MIN_VALUE; // Initialize to the smallest possible value
    boolean isValid = true;
    
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
    
    void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left); // Traverse the left subtree
        
        int val = root.val;
        // Check if current node value is greater than the previous node value
        if (prev >= val) {
            isValid = false;
            return;
        }
        prev = val; // Update previous node value
        
        if (root.right != null) inorder(root.right); // Traverse the right subtree
    }
}