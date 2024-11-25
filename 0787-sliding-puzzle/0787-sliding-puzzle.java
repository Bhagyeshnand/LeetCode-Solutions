/**
 * Double-Ended BFS + Bit Manipulation
 *
 * Find possible zero moves for each zero location. Use this to find next states
 * of current state. Perform Double-Ended BFS to find the total number of moves.
 *
 * To save space, we are using a single integer to represent a state. Since our
 * number is between 0 & 5, it will take maximum 3 bits for each number. Thus we
 * will need only 18 bits to store each state.
 *
 * Time Complexity: O(V + E).
 * V = Number of possible states = (M*N)!.
 * E = 3 * V, because there can be a maximum of 3 edges from each vertex.
 * Total TC = O((MN)! + 3*(MN)!) = O((MN)!) = O(4 * 6!)
 *
 * Space Complexity: O((MN)!) to save each state in begin, end and visited
 * collections = O(6!)
 *
 * M = Number of rows. N = Number of cols.
 */
class Solution {
    // 3-Bit Binary representation of 123450
    private static final int FINAL_STATE = 0b001010011100101000;
    // Possible destination of zero. Here DIRS[0] represents the most significant
    // 3-Bit number in the state. And, DIRS[5] represents the least significant
    // 3-Bit number in the state.
    private static final int[][] DIRS = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length != 2 || board[0].length != 3) {
            throw new IllegalArgumentException("Input board is invalid");
        }

        int zeroIdx = -1;
        int curState = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                // Inserting the num at the end of integer
                curState = (curState << 3) | board[i][j];
                if (board[i][j] == 0) {
                    zeroIdx = i * 3 + j;
                }
            }
        }

        if (FINAL_STATE == curState) {
            return 0;
        }

        HashSet<Integer> visited = new HashSet<>();
        int moves = 0;

        HashMap<Integer, Integer> begin = new HashMap<>();
        begin.put(curState, zeroIdx);
        visited.add(curState);

        HashMap<Integer, Integer> end = new HashMap<>();
        end.put(FINAL_STATE, 5);
        visited.add(FINAL_STATE);

        while (!begin.isEmpty()) {
            if (begin.size() > end.size()) {
                HashMap<Integer, Integer> tempSet = begin;
                begin = end;
                end = tempSet;
            }

            HashMap<Integer, Integer> next = new HashMap<>();
            moves++;
            for (int cur : begin.keySet()) {
                zeroIdx = begin.get(cur);

                for (int d : DIRS[zeroIdx]) {
                    int newState = swap(cur, zeroIdx, d);
                    if (end.containsKey(newState)) {
                        return moves;
                    }
                    if (visited.add(newState)) {
                        next.put(newState, d);
                    }
                }
            }
            begin = next;
        }

        return -1;
    }

    private int swap(int state, int zeroIdx, int destIdx) {
        // Generate mask for destIdx
        int mask = 0b111 << ((5 - destIdx) * 3);
        // Extracting num at destIdx
        int num = state & mask;
        // Moving num to zeroIdx
        if (zeroIdx < destIdx) {
            num <<= (destIdx - zeroIdx) * 3;
        } else {
            num >>>= (zeroIdx - destIdx) * 3;
        }

        // Setting zero at destIdx
        state &= ~mask;
        // Setting num at zeroIdx
        return state | num;
    }
}