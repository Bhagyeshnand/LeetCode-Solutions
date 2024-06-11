class Solution {
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long result = 0;
        int mod = 1_000_000_007;

        for (int num : nums) {
            int diff = num - reverse(num);
            countMap.put(diff, countMap.getOrDefault(diff, 0) + 1);
        }

        for (int count : countMap.values()) {
            if (count > 1) {
                result += (long) count * (count - 1) / 2;
                result %= mod;
            }
        }

        return (int) result;
    }
}