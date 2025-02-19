class Solution {
    String result= "";
    int count = 0;
    public String getHappyString(int n, int k) {
        buildHappyStrings(n,k,new StringBuilder());
        if(count < k)
            return "";
        return result.toString();
    }

    public void buildHappyStrings(int n, int k, StringBuilder sb){
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
                return;
            }
        }
        int sbLen = sb.length();
        if(sbLen < n && count < k){
            for(char c = 'a'; c <='c'; c++){
                if(sbLen == 0 || sb.charAt(sbLen-1) != c){
                    sb.append(c);
                    buildHappyStrings(n,k,sb);
                    sb.deleteCharAt(sbLen);
                }
            }
        }
        
    }
}