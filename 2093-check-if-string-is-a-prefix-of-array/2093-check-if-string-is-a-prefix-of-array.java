class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String a="";
        for(int i=0;i<words.length;i++){
            a+=words[i];
            if(a.equals(s)){
                return true;
            }
        }
        return false;
    }
}