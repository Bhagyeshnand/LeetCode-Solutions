class Solution {
    public int minSteps(String s, String t) {
        int[] a = new int[26];    
        int[] a1= new int[26];

        for(char c: s.toCharArray()){
            a[c-'a']++;
        }   
        for(char c: t.toCharArray()){
            a1[c-'a']++;
        }   

        int count = 0;
        for(int i=0; i<26; i++){
            if(a[i]<a1[i]){
                count += a1[i]-a[i];
                a[i] = a1[i];
            }
            else if(a1[i]<a[i]){
                count += a[i]-a1[i];
            }
        }
        return count;
    }
}