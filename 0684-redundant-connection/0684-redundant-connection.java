class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        for(int i =0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            if(ds.findParent(a) == ds.findParent(b)){
                return new int[]{a,b};
            }
            else{
                ds.UnionBySize(a,b);
            }
        }
        return new int[2];
    }
}
class DisjointSet{
    int[] parent;    int[] size;
    
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i =0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        // Path Compression
        return parent[node] = findParent(parent[node]);
    } 
    
    public void UnionBySize(int node1,int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        if(parent1 == parent2)return;
        
        if(size[parent1] > size[parent2]){
            parent[parent2] = parent[node1];
            size[parent1]+=size[parent2];
        }
        else{
            parent[parent1] = parent[node2];
            size[parent2]+=size[parent1];
        }
        
    }
}
class Pair{
    int node1;
    int node2;
    int weight;
    Pair(int node1,int node2,int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}