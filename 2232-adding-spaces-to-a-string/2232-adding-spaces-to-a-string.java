class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] ch=s.toCharArray();
        char[] charr=new char[s.length()+spaces.length];
        int idx=0,c=0;
        for (int sp:spaces){
            while (c<sp){
                charr[idx]=ch[c];
                idx++;
                c++;
            }
            charr[idx]=' ';
            idx++;
        }
        while(c<s.length()){
            charr[idx]=ch[c];
            idx++;
            c++;
        }
        return new String(charr);



/*

        StringBuilder res=new StringBuilder();
        int k=0;
        int i=0;
        while(i<s.length()){
            
            if (k<spaces.length){
            if (i==spaces[k]){
                res.append(" ");
                k++;}
            }
            res.append(s.charAt(i++));

        }
        return res.toString();
        */
    }

}