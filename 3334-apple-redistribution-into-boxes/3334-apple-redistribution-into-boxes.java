import java.util.Arrays;

public class Solution {
    public int minimumBoxes(int[] a, int[] c) {
        int ans = 0;
        int s = Arrays.stream(a).sum();
        Arrays.sort(c);

        int i = c.length - 1;
        while (i >= 0) {
            s -= c[i];
            ans++;
            if (s <= 0)
                break;
            i--;
        }

        return ans;
    }
}
