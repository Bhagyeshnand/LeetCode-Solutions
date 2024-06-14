class Solution {
    public boolean halvesAreAlike(String s) {
        int[] a = new int[123];
        int[] b = new int[123];
        int strLen = s.length();
        return checkVowel(0, strLen/2, a, s) == checkVowel(strLen/2, strLen, b, s);
    }

    public static int checkVowel(int start, int end, int[] freq, String s){
        while(start < end) {
            freq[s.charAt(start++)]++;
        }
        return freq['a'] + freq['A'] + freq['e']+freq['E']+freq['i']+freq['I']+freq['o']+freq['O']+
                freq['u']+freq['U'];
    }
}

// class Solution {

//     public boolean isVowel(char ch) {
//         return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
//                 ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' );
//     }
//     public boolean halvesAreAlike(String s) {
//         int n =s.length();
//         int i = 0, j = n/2, countleft = 0, countright = 0;

//         while(i<n/2 && j<n){
//             if(isVowel(s.charAt(i++))) ++countleft;
//             if(isVowel(s.charAt(j++))) ++countright;
//         }
//         return countleft == countright;
//     }
// }