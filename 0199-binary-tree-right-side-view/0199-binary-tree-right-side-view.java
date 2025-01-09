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
    int maxLevel =0;
    List<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode root, int level) {
        if (root==null){
            return;
        }
        if(maxLevel<level){
            res.add(root.val);
            maxLevel = level; 
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int count = q.size();
            for (int i =0; i<count; i++){
                TreeNode node = q.poll();
                if(i==count-1){
                    ans.add(node.val);
                }
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);

            }
        }
        return ans;
    }
}