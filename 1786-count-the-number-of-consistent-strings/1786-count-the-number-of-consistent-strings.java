class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet <Character> st = new HashSet<>();

        for(char e : allowed.toCharArray()){
            st.add(e);
        }

        for( String s : words){
            count++;
            for( char ch : s.toCharArray()){
                if(!st.contains(ch)){
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}