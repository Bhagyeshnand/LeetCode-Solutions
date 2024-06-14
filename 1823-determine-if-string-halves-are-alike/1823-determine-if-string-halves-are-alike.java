class Solution {

    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' );
    }
    public boolean halvesAreAlike(String s) {
        int n =s.length();
        int i = 0, j = n/2, countleft = 0, countright = 0;

        while(i<n/2 && j<n){
            if(isVowel(s.charAt(i++))) ++countleft;
            if(isVowel(s.charAt(j++))) ++countright;
        }
        return countleft == countright;
    }
}