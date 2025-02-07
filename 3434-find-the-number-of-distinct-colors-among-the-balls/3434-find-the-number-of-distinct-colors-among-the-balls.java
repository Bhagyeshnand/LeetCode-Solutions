class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> node = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int it[]=queries[i];
            if(node.containsKey(it[0])){
                if(node.get(it[0])==it[1]) {
                    ans[i]=color.size();continue;
                }
                else if (color.get(node.get(it[0]))<=1) color.remove(node.get(it[0]));
                else
                color.put(node.get(it[0]),color.get(node.get(it[0]))-1);
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            else{
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            ans[i]=color.size();
        }
        return ans;
    }
}