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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<Integer> pathList = new ArrayList<>();
    	List<List<Integer>> variousPathList = new ArrayList<>();

		variousPathSum(root, targetSum, pathList, variousPathList);
		return variousPathList;
    }

	public void variousPathSum(TreeNode root, int targetSum, List<Integer> pathList, List<List<Integer>> variousPathList){
		
		if(root == null) return;	

		pathList.add(root.val);

		if(root.left == null && root.right == null && targetSum-root.val == 0) {
			variousPathList.add(new ArrayList<>(pathList));
		} 
		else {
			variousPathSum(root.left, targetSum-root.val, pathList, variousPathList);
			variousPathSum(root.right, targetSum-root.val, pathList, variousPathList);
		}

		pathList.remove(pathList.size()-1);
		
	}
}