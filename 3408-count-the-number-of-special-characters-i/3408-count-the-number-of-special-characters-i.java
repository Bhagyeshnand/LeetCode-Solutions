class Solution {
    public int numberOfSpecialChars(String word) {
       char lower='a';
        char upper='A';
        int count=0;
        for(int i=0;i<26;i++){
            String lower1=lower+"";
            String upper1=upper+"";
         if(word.contains(lower1)&& word.contains(upper1))count++;
         lower++;
         upper++;
        }return count;
    }
}