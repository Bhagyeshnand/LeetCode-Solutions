class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, p = 1;
        for (int i = 0; i < 4; i++) {
            int t = Math.min(num1 % 10, num2 % 10);
            t = Math.min(t, num3 % 10);
            ans += t * p;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            p *= 10;
        }
        return ans;
    }
}