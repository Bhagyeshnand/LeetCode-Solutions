class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n];
        boolean LtoR = true;
        int idx = 0;

        //flatten the board into 1D array
        for(int i = n - 1 ; i >= 0 ; i--){
            if(LtoR){
                for(int j = 0 ; j < n ; j++){
                    arr[idx++] = board[i][j];
                }
            }
            else{
                for(int j = n - 1 ; j >= 0 ; j--){
                    arr[idx++] = board[i][j];
                }
            }

            LtoR = !LtoR;
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n*n];
        q.offer(0);
        vis[0] = true;

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int k = 0 ; k < size ; k++){
                int curr = q.poll();

                if(curr == n*n - 1) return moves; 

                for(int dice = 1 ; dice <= 6 ; dice++){
                    int next = curr + dice;

                    if(next >= n*n) break;

                    if(arr[next] != -1){
                        next = arr[next] - 1; //convert to idx of 1D arr
                    }

                    if(!vis[next]){
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}