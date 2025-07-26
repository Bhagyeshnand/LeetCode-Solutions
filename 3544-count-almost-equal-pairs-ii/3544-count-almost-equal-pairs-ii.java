class Solution {
    static final int[] pow = {1, 10, 100, 1000, 10000, 100000, 1000000};
    public int countPairs(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>(nums.length << 3);
        int[] digits = new int[7];

        for (int x : nums) {
            Set<Integer> set = new HashSet<>();
            set.add(x); // 不交换
            ans += count.getOrDefault(x, 0);
            int m = 0;
            for (int v = x; v > 0; v /= 10) 
                digits[m++] = v % 10;
            
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (digits[i] == digits[j])  // 小优化
                        continue;
                    
                    int y = x + (digits[j] - digits[i]) * (pow[i] - pow[j]);
                    if (set.add(y)) 
                        ans += count.getOrDefault(y, 0); // 交换一次
                    
                    swap(digits, i, j);
                    for (int p = i + 1; p < m; p++) {
                        for (int q = p + 1; q < m; q++) {
                            int z = y + (digits[q] - digits[p]) * (pow[p] - pow[q]);
                            if (set.add(z)) 
                                ans += count.getOrDefault(z, 0); // 交换两次
                        }
                    }
                    swap(digits, i, j);
                }
            }

            count.merge(x, 1, Integer::sum);
        }
        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;        
    }
}