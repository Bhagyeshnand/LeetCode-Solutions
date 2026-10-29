class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] steps = new int[n];
        Arrays.fill(steps, 1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
                List<Integer> popIndices = new ArrayList<>();
                popIndices.add(stack.pop());
                while (!stack.isEmpty() && arr[stack.peek()] == arr[popIndices.get(0)]) {
                    popIndices.add(stack.pop());
                }
                for (int j : popIndices) {
                    if (i < n && i - j <= d) {
                        steps[i] = Math.max(steps[i], steps[j] + 1);
                    }
                    if (!stack.isEmpty() && j - stack.peek() <= d) {
                        int leftIdx = stack.peek();
                        steps[leftIdx] = Math.max(steps[leftIdx], steps[j] + 1);
                    }
                }
            }
            if (i < n) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int x : steps) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}