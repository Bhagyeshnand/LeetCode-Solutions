class Solution {
    public int numberOfSpecialChars(String word) {
      int count=0;
      for(char i='a',j='A';i<='z'&&j<='Z';i++,j++){
        if(word.indexOf(i)!=-1&&word.indexOf(j)!=-1){
            count++;
        }
      }  
      return count;
    }
}