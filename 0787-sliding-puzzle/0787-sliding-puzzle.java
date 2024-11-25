class Solution {
    int min = Integer.MAX_VALUE;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {
        int[] zero = {-1, -1};
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero = new int[]{i, j};
                    break outer;
                }
            }
        }
        helper_backtrack(board, 0, new int[]{-1, -1}, zero);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void helper_backtrack(int[][] board, int moves, int[] last, int[] curr) {
        if (moves >= 20) return;
        if (helper_isDone(board)) {
            min = Math.min(min, moves);
            return;
        }
        for (int[] dir : dirs) {
            int i = curr[0] + dir[0];
            int j = curr[1] + dir[1];
            if (i < 0 || i >= 2 || j < 0 || j >= 3 || (last[0] == i && last[1] == j)) continue;
            int[] newMove = {i, j};
            helper_flip(board, curr, newMove);
            helper_backtrack(board, moves + 1, curr, newMove);
            helper_flip(board, curr, newMove);
        }
    }
    public void helper_flip(int[][] board, int[] f, int[] s) {
        int temp = board[f[0]][f[1]];
        board[f[0]][f[1]] = board[s[0]][s[1]];
        board[s[0]][s[1]] = temp;
    }
    public boolean helper_isDone(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 2) return true;
                if (board[i][j] != 3 * i + j + 1) return false;
            }
        }
        return true;
    }
}