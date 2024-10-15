class Solution {
    public long minimumSteps(String s) {
       char[] sarr = s.toCharArray();
       int zeroes=0;
       long tot=0;
       for(int i=0;i<sarr.length;i++){
        if(sarr[i]=='1'){
            zeroes++;
        }else{
            tot+=zeroes;
        }
       }
       return tot;
    }
}