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
    int j = 0;
    public void Trav(TreeNode root, ArrayList<Integer> ar){
        if(root == null) return ;
        
        Trav(root.left, ar);
        ar.add(root.val);
        Trav(root.right, ar);
    }

    public void Update(TreeNode root,int [] sum){
        if(root == null) return ;
        
        Update(root.left,sum);
        root.val = sum[j++];
        Update(root.right,sum);
    }

    public TreeNode bstToGst(TreeNode root) {
        TreeNode r = root;
        ArrayList<Integer> ar = new ArrayList<>();
        Trav(root,ar);
        int n = ar.size();
        int[] sum = new int[n];

        sum[n-1] = ar.get(n-1);
        for(int i= ar.size()-2; i>=0;i--){
            sum[i] = sum[i+1] + ar.get(i);
        }

        for(int i :sum){
            System.out.println(i);
        }

        Update(root,sum);
        return r;
        
    }
}