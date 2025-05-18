class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> res=new ArrayList<>();
        long val=1;
        for(int i=0;i<=n;i++){
            res.add((int)val);
            val=val*(n-i)/(i+1);
        }
        return res;

        
    }
}