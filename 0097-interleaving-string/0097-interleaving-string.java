class Solution {

    String s1;
    String s2;
    String s3;

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s3.length()!=(s1.length()+s2.length())){
            return false;
        }

        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.memo = new Boolean[s1.length()+1][s2.length()+1];

        return findMatch(0,0);

        // int s1Index =0;
        // int s2Index = 0;

        // for(int i=0;i<s3.length();i++){
        //     System.out.println("s3="+s3.charAt(i)+" s1="+s1Index+" s2="+s2Index);
        //     if(s1Index<s1.length() && s3.charAt(i)==s1.charAt(s1Index)){
        //         s1Index++;
        //     }else if(s2Index<s2.length() && s3.charAt(i)==s2.charAt(s2Index)){
        //         s2Index++;
        //     }else{
        //         return false;
        //     }
        // }

        // return true;

    }


    public boolean findMatch(int s1Index,int s2Index){
        if((s1Index+s2Index)>=s3.length()){
            return true;
        }

        if(memo[s1Index][s2Index]!=null){
            return memo[s1Index][s2Index];
        }

        if(s1Index<s1.length() && s3.charAt((s1Index+s2Index))==s1.charAt(s1Index)){
            if(findMatch(s1Index+1,s2Index)){
                memo[s1Index][s2Index] = true;
                return true;
            }
        }
        
        if(s2Index<s2.length() && s3.charAt((s1Index+s2Index))==s2.charAt(s2Index)){
            if(findMatch(s1Index,s2Index+1)){
                memo[s1Index][s2Index] = true;
                return true;
            } 
        }

        memo[s1Index][s2Index] = false;
        return false;
    }
}