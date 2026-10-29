class Solution {
    static {
        for (int i = 0; i <= 500; i++) {
            dailyTemperatures(new int[1]);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        //13 10   9 8 7 6 5   12  9 8 7 5 15 
        ans[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            // a_i-1 a_i
            if (temperatures[i] < temperatures[i + 1]) {
                ans[i] = 1;
            } else if (temperatures[i] == temperatures[i + 1]) {
                ans[i] = ans[i + 1] != 0 ? ans[i + 1] + 1 : 0;
            } else {
                int k = i + 1 + ans[i + 1];
                while (temperatures[i] >= temperatures[k] && k < n && ans[k] != 0) {
                    k = k + ans[k];
                }
                if (ans[k] == 0) {
                    ans[i] = 0;
                }
                if (temperatures[i] < temperatures[k]) {
                    ans[i] = k - i;
                }
            }
        }

        return ans;
    }
}