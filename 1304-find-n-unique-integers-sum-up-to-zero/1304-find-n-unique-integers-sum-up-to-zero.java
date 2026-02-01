class Solution {
    public int[] sumZero(int n) {
        if(n==1){
            return new int[]{0};
        }
        int[] ans=new int[n];
        ArrayList<Integer> l=new ArrayList<>();
        if(n%2==0){
            for(int i=1;i<=n/2;i++){
                l.add(i);
                l.add(-1*i);
            }
        }else{
            for(int i=1;i<=n/2;i++){
                l.add(i);
                l.add(-1*i);
            }
            l.add(0);
        }
        int x=0;
        for(int a : l){
            ans[x++]=a;
        }
        return ans;
    }
}