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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] mem = new List[n + 1][n + 1];
        return generateTreesUtil(1, n, mem);
    }

    private List<TreeNode> generateTreesUtil(int min, int max, List<TreeNode>[][] mem) {
        List<TreeNode> trees = new ArrayList<>();
        if (min > max) {
            trees.add(null);
            return trees;
        }

        if (mem[min][max] != null) {
            return mem[min][max];
        }
        
        for (int root = min; root <= max; root++) {
            for (TreeNode left : generateTreesUtil(min, root - 1, mem)) {
                for (TreeNode right : generateTreesUtil(root + 1, max, mem)) {
                    trees.add(new TreeNode(root, left, right));
                }
            }
        }
        return mem[min][max] = trees;
    }
}