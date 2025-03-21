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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;

        while(!dq.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            for(int i = dq.size(); i > 0; i--){
                TreeNode curr = (leftToRight)?dq.pollFirst():dq.pollLast();
                currLevel.add(curr.val); 
                if(leftToRight){
                    if(curr.left != null)
                        dq.offerLast(curr.left);
                    if(curr.right != null)
                        dq.offerLast(curr.right);
                }   
                else{
                    if(curr.right != null)
                        dq.offerFirst(curr.right);
                    if(curr.left != null)
                        dq.offerFirst(curr.left);
                }
            }
            
            leftToRight = !leftToRight;
            result.add(currLevel);
        }
        return result;
    }
}       