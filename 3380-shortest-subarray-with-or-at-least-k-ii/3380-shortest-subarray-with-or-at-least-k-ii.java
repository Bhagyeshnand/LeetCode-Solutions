class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int w = 0, min = Integer.MAX_VALUE;
        int[] bits = new int[32]; // bits' counts
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] >= k) return 1;
            w |= nums[r];
            for (int i = 0; i < bits.length; i++) {
                bits[i] += (nums[r] >> i) & 1;
            }
            while (w >= k) {
                min = Math.min(min, r - l + 1);
                for (int i = 0; i < bits.length; i++) {
                    bits[i] -= (nums[l] >> i) & 1;
                    if (bits[i] == 0) w &= ~(1 << i);
                }
                l++;
            } 
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int prefix_bs(int[] nums, int k) { // doesn't work :(
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) return 1;
            prefix[i + 1] = prefix[i] | nums[i];
        }
        System.out.println(Arrays.toString(prefix));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] >= k) {
                int l = 0, r = i;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    int s = prefix[i] & ~prefix[m];
                    if (s < k) {
                        r = m;
                    } else {
                        l = m + 1;
                        min = Math.min(min, i - m);
                    }
                }
            }
        }
        return min;
    }
}
/*
[2,1,8], k = 10
prefix=[0,2,3,11]
l=0 r=3 m=1 => 1011(11) & ~0010(2) => 1001(9) < k
l=0 r=1 m=0 => 1011(11) & ~0000(0) => 1011(11) > k
l=1 r=1 => end

[8,1,2], k = 10
prefix=[0,8,9,11]

l=0 r=3 m=1 => 1011(11) & ~1000(8) => 11(3) < k
l=0 r=1 m=0 => 1011(11) & ~0000(0) => 1011(11) > k
l=1 r=1 => end
*/