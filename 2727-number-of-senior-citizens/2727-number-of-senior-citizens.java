class Solution {
    public int countSeniors(String[] details) {
        int total = 0;
        for( String s : details){
            if('7' <= s.charAt(11)){ total++;}
            else if('6' == s.charAt(11) && '0' < s.charAt(12)){ total++;}
        }
    return total;
    }
}