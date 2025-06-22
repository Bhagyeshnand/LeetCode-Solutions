class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = 100001l * nums[i] + i;
        }
        Arrays.sort(arr);
        long[] res = new long[queries.length];
        int idx = 0;
        for (int i = 0; i < queries.length; i++) {
            sum -= nums[queries[i][0]];
            nums[queries[i][0]] = 0;
            int j = queries[i][1];
            while (j > 0 && idx < arr.length) {
                int num = (int) (arr[idx] / 100001);
                int idx1 = (int) (arr[idx++] % 100001);
                if (nums[idx1] == 0)
                    continue;
                sum -= num;
                nums[idx1] = 0;
                j--;
            }
            res[i] = sum;
        }
        return res;
    }
}