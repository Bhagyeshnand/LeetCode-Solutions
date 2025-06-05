class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int[][] diff1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] diff2 = generate(Arrays.copyOfRange(nums, n / 2, n));

        int min = Integer.MAX_VALUE;
        for (int len = 0; len <= n / 2; len++) {
            int[] left = diff1[len];
            int[] right = diff2[n/2 - len];

            int l = 0;
            int r = diff2[n/2 - len].length - 1;

            while (l < left.length && r >= 0) {
                // arrays are already sorted so we move one pointer at a time to make the diff
                // closer to 0
                int diff = left[l] + right[r];
                min = Math.min(min, Math.abs(diff));
                if (diff < 0)
                    l++;
                else if (diff > 0)
                    r--;
                else
                    return 0;
            }
        }

        return min;
    }

    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int m = 1 << n;

        int total = 0;
        for (int num : nums)
            total += num;

        for (int i = 0; i < n; i++)
            nums[i] <<= 1;

        int[] sums = new int[m];
        sums[0] -= total;

        for (int i = 0, maxTo = 1; i < n; i++, maxTo <<= 1) {
            int num = nums[i];
            for (int from = 0, to = maxTo; from < maxTo; from++, to++)
                sums[to] = sums[from] + num;
        }

        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];

        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial];
            binomial = binomial * (n - i) / (i + 1);
        }

        for (int key = 0; key < m; key++) {
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sums[key];
        }

        for (int[] arr : ans)
            Arrays.sort(arr);

        return ans;
        
    }
}