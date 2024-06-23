class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n=k;
        HashMap<String,Integer> map =new HashMap<>();

        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(String x : arr){
            if(map.get(x)==1){
                --n;
                if(n==0){
                    return x;
                }
            }
        }
        return "";
    }
}