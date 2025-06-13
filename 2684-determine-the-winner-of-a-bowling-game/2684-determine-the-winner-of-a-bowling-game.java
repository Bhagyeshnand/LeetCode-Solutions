class Solution {
      public int isWinner(int[] p1, int[] p2) {
        int ans=0,s1=0,s2=0;
        int n=p1.length;
       for(int i=0;i<n;i++){
               s1+=p1[i];
               s2+=p2[i];
           }
        if(n>1) {
            for(int i=1;i<n;i++){
                if(p1[i-1]==10 ||((i>=2) && p1[i-2]==10))s1+=p1[i];
                if(p2[i-1]==10 ||((i>=2)&& p2[i-2]==10))s2+=p2[i];
            }
        }
        if(s1==s2) ans= 0;
        else if(s1>s2) ans= 1;
        else ans= 2;
        return ans;
        
    }
}