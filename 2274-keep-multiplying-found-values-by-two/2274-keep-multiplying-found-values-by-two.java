class Solution {
    public int findFinalValue(int[] nums, int k) {
        int bits = 0;
        for (int num : nums) {
            if (num % k != 0) continue;
            int n = num / k;
            if ((n & (n - 1)) == 0)
                bits |= n;
        }
        bits++;
        return k * (bits & -bits);
    }
}
