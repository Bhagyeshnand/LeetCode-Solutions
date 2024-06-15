/*class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            cnt.merge(Arrays.toString(row), 1, Integer::sum);
        }
        int pairs = 0;
        for (int c = 0, n = grid.length; c < n; ++c) {
            int[] col = new int[n];
            for (int r = 0; r < n; ++r) {
                col[r] = grid[r][c];
            }
            pairs += cnt.getOrDefault(Arrays.toString(col), 0);
        }
        return pairs;
    }
}

/ cnt.merge(Arrays.toString(row), 1, Integer::sum); is same as

// String key = Arrays.toString(row);
// cnt.put(key, 1 + cnt.getOrDefault(key, 0));
// Arrays.toString(row)/value is key/value binding of HashMap cnt;

// Integer::sum here means that the method sum of Integer 
//  is used to increase by 1
//  the value corresponding to key: Arrays.toString(row).
//  The default value is 0 in case the key is absent.


*/
class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<n;i++){
            int hash = rowHash(grid[i]);
            map.put(hash,map.getOrDefault(hash,0)+1);
        }
        for(int i=0;i<n;i++){
            int hash = colHash(grid, i);
            ans+=map.getOrDefault(hash,0);
        }
        return ans;
    }
    private int rowHash(int[] arr){
        int hash = 0;
        for(int i:arr){
            hash=i+7*hash;
        }
        return hash;
    }
    private int colHash(int[][] grid, int i){
        int n = grid.length;
        int hash = 0;
        for(int[] x: grid){
            hash = x[i]+7*hash;
        }
        return hash;
    }
}