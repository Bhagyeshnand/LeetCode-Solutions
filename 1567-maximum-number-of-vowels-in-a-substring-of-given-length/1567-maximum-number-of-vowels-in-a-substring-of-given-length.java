class Solution {
    public int maxVowels(String s, int k) {

//      Initialize i and j from 0.
        int i = 0;
        int j = 0;

//      vowel is vowel count in current substring.
//      max is the maximum vowel in any substring.
        int vowels = 0;
        int max = 0;

//      we need ch variable to store ith and jth character.
        char ch;

//      Iterate while we get a substring of length k.
        while(j < k)
        {
            ch = s.charAt(j);

            //if ch is a vowel, then increase vowels count.
            
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                vowels++;
            j++;
        }
//      we assume that the first substring has maximum vowels.
        max = vowels;

//      Now j is equal to k.

//      Iterate while j < string length.        
        while(j < s.length())
        {
            //ch stores ith character, (initially i = 0)
            ch = s.charAt(i);

            //if ch is a vowel then decrement vowel count.
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                vowels--;

            //ch stores the new jth character.
            ch = s.charAt(j);
            
            //if ch is vowel then 
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                vowels++;

//          store the maximum vowel count in the max.
            max = Math.max(max, vowels);
            
//          Increment i and j variables.
            i++;
            j++;
        }

//      Finally, return the max variable.
        return max;

    }
}