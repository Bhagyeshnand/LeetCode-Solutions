class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        char[] ca= s.toCharArray();
        int n= ca.length;
        
        char[] freq= new char[26];
        for(int i=0; i<n; i++)
            ++freq[ca[i]-'a'];

        // all candidate subsequences grouped by length - max subsequence length==7
        ArrayList<String>[] cand= new ArrayList[8];
        cand[1]= new ArrayList<>();
        String ans= "";
        for(int i=0; i<26; i++)
            if(freq[i]>=k)
                cand[1].add(ans= "" + (char)('a'+i));
        // the candidate subsequence can start with any of characters with freq>=k
        for(int i=2; i<8; i++){
            cand[i]= new ArrayList<>();
            for(String prev:cand[i-1])
                for(String c:cand[1]){
                    String next= prev+c;
                    if(isSubsequenceRepeatedK(ca, next, k))
                        cand[i].add(ans= next);
                }
        }
        return ans;
    }
    
    boolean isSubsequenceRepeatedK(char[] ca, String t, int k){
        char[] ta= t.toCharArray();
        int n= ca.length, m= ta.length, i= 0;
        while(k-->0){
            int j=0;
            while(i<n && j<m){
                if(ca[i]==ta[j]) j++;
                i++;
            }
            if(j!=m) return false;
        }
        return true;
    }
}