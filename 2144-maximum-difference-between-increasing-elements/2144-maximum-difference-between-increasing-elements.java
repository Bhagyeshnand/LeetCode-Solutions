class Solution {
    public int maximumDifference(int[] nums) {
        Stack<int[]> stack = new Stack<>(); // [value, index]
        int diff = -1;

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < stack.peek()[0]) {
                stack.push(new int[]{nums[i], i});
            }

            if (!stack.isEmpty() && stack.peek()[1] < i && nums[i] > stack.peek()[0]) {
                diff = Math.max(diff, nums[i] - stack.peek()[0]);
            }
        }

        return diff;
    }
}
