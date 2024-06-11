class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch >='0' && ch <= '9'){
                ans.deleteCharAt(ans.length()-1);
            }else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}