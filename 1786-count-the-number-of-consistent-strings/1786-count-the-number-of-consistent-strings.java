class Solution {
    boolean[] s;
    public int countConsistentStrings(String allowed, String[] words) {
        s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w)) ++ans;
        }
        return ans;
    }

    private boolean check(String w) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) return false;
        }
        return true;
    }
}

// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         int count = 0;
//         HashSet <Character> st = new HashSet<>();

//         for(char e : allowed.toCharArray()){
//             st.add(e);
//         }

//         for( String s : words){
//             count++;
//             for( char ch : s.toCharArray()){
//                 if(!st.contains(ch)){
//                     count--;
//                     break;
//                 }
//             }
//         }

//         return count;
//     }
// }