class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        

        int candiesCount = 0;

        boolean[] visited = new boolean[status.length];

        for(int box: initialBoxes){
            //if(status[box] == 1){
                dfs(box, status, keys, containedBoxes, visited);
            //} 
        }

        for(int i = 0; i < candies.length; i++){
            if(visited[i] && status[i] == 1){
                candiesCount += candies[i];
            }
            
        }


        return candiesCount;
    }


    private void dfs(int box, int[] status, int[][] keys, int[][] containedBoxes, boolean[] visited){

        visited[box] = true;

        for(int key: keys[box]){
            if(key == box){
                continue;
            }
            status[key] = 1;
        }

        for(int bx: containedBoxes[box]){
            if(!visited[bx]){
                dfs(bx, status, keys, containedBoxes, visited);
            }
        }
    }
}