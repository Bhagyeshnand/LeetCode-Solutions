class Solution {
    int[][] rects;
    int[] sum;
    int tot = 0;
    Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        sum = new int[rects.length];
        int i = 0;
        for (int[] x : rects) {
            tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
            sum[i++] = tot;
        }
    }
    
    public int[] pick() {
        // find a random num < n
        int rand = random.nextInt(tot);

        // find which rec the point is in
        // binary search
        int l = 0, r = rects.length - 1;
        while (l != r) {
            int mid = (l + r) / 2;
            if (rand >= sum[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        // return x, y
        int[] x = rects[l];
        int width = (x[2] - x[0] + 1);
        int height = (x[3] - x[1] + 1);
        int base = sum[l] - (width * height);

        return new int[]{(x[0] + (rand - base) % width), (x[1] + (rand - base) / width)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */