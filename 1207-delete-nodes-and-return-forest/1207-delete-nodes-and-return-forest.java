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
    private TreeNode deleteHelper(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null) {
            return null;
        }

        root.left = deleteHelper(root.left, toDelete, result);
        root.right = deleteHelper(root.right, toDelete, result);

        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        } else {
            return root;
        }
    }

     public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();

        for (int num : to_delete) {
            toDelete.add(num);
        }

        deleteHelper(root, toDelete, result);

        if (!toDelete.contains(root.val)) {
            result.add(root);
        }

        return result;
    }
}