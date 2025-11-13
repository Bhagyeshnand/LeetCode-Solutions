class Solution {
    public int maxOperations(String s) {
        int index = s.length() - 1, res = 0, running = 0;
        while(index >= 0){
            while(s.charAt(index) == '1'){
                index--;
                res += running;
                if(index < 0) return res;
            }
            while(s.charAt(index) == '0'){
                index--;
                if(index < 0) return res;
            } 
            running++;
        }
        return res;
    }
}