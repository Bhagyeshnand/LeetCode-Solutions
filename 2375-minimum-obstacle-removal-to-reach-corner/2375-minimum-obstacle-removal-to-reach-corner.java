class Solution {
    public int minimumObstacles(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        int[][] dist = new int[r][c];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        while (!dq.isEmpty()) {
            int[] cell = dq.pollFirst();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    int d = dist[x][y] + grid[nx][ny];
                    if (d < dist[nx][ny]) {
                        dist[nx][ny] = d;
                        if (grid[nx][ny] == 0) {
                            dq.offerFirst(new int[]{nx, ny});
                        } else {
                            dq.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return dist[r - 1][c - 1];
    }
}