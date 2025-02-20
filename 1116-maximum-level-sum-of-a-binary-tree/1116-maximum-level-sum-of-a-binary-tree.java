class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return 0;
        // Simple BFS
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            int level = queue.size();
            for(int i = 0; i < level; i++){
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                subList.add(queue.poll().val);
            }
            int sum = sumList(subList);
            list.add(sum);
        }
        int maxLevel = maxSum(list)+1;
        return maxLevel;
    }

    // Sum of Array Function
    public int sumList(ArrayList<Integer> list){
        int sum = 0;
        for(int i: list){
            sum += i;
        }
        return sum;
    }

    // Max of Array Function
    public int maxSum(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return list.indexOf(max);
    }
}