class Solution {
    public boolean checkOnesSegment(String s) {
        int st=0;
        boolean f=true;
        int c=0;
       
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)=='0' && s.charAt(i)=='1'){
                f=false;
                break;
            }
        }
        return f;
    }
}