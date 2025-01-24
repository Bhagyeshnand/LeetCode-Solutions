import java.util.AbstractList;
class Solution {
    List<Integer> safeNodes;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // int n = graph.length;
        // List<List<Integer>> reverseAdj = new ArrayList<>();
        // List<Integer> safeNodes = new ArrayList<>();
        // int[] inDegree = new int[n];

        // for(int i = 0; i < n; i++){
        //     reverseAdj.add(new ArrayList<>());
        // }

        // for(int i = 0; i < n; i++){
        //     for(int neighborNode: graph[i]){
        //         reverseAdj.get(neighborNode).add(i);
        //         inDegree[i]++;
        //     }
        // }

        // Queue<Integer> queue = new LinkedList<Integer>();
        // for(int i = 0; i < n; i++){
        //     if(inDegree[i] == 0){
        //         queue.offer(i);
        //     }
        // }

        // while(!queue.isEmpty()){
        //     int safeNode = queue.poll();
        //     safeNodes.add(safeNode);

        //     for(int neighbor : reverseAdj.get(safeNode)){
        //         inDegree[neighbor]--;
        //         if(inDegree[neighbor] == 0){
        //             queue.offer(neighbor);
        //         }
        //     }
        // }
        // Collections.sort(safeNodes);
        // return safeNodes;
        return new AbstractList<Integer>(){
            @Override
            public Integer get(int index){
                init();
                return safeNodes.get(index);
            }

            @Override
            public int size(){
                init();
                return safeNodes.size();
            }

            private void init(){
                if(safeNodes != null) return;

                int n = graph.length;
                List<List<Integer>> reverseAdj = new ArrayList<>();
                safeNodes = new ArrayList<>();
                int[] inDegree = new int[n];

                for(int i = 0; i < n; i++){
                    reverseAdj.add(new ArrayList<>());
                }

                for(int i = 0; i < n; i++){
                    for(int neighborNode: graph[i]){
                        reverseAdj.get(neighborNode).add(i);
                        inDegree[i]++;
                    }
                }

                Queue<Integer> queue = new LinkedList<Integer>();
                for(int i = 0; i < n; i++){
                    if(inDegree[i] == 0){
                        queue.offer(i);
                    }
                }

                while(!queue.isEmpty()){
                    int safeNode = queue.poll();
                    safeNodes.add(safeNode);

                    for(int neighbor : reverseAdj.get(safeNode)){
                        inDegree[neighbor]--;
                        if(inDegree[neighbor] == 0){
                            queue.offer(neighbor);
                        }
                    }
                }
                Collections.sort(safeNodes);
            }
        };   
    }
}