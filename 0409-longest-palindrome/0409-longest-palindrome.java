class Solution {
    public int longestPalindrome(String s) {
        int[] array = new int[58];
        int count = 0,odd = 0;

        for(char each : s.toCharArray()){
            array[each - 'A']++;
        }

        for(int each : array){
            if(each % 2 == 0 && each != 0){
                count += each;
            }else if(each % 2 == 1 && each != 1){
                count += each -1; 
                odd = 1;
            }else if(each == 1){
                odd = 1;
            }
        }

        return count + odd;


        // return array[25];
    }
}

// class Solution {
//     public int longestPalindrome(String s) {
//         if(s.length() == 1) return 1;

//     HashMap <Character,Integer> mp = new HashMap<>();
//     int count = 0;

//     for(char n : s.toCharArray()){
//         mp.put(n,mp.getOrDefault(n,0)+1);
//         if(mp.get(n) == 2){
//             count+=2;
//             mp.put(n,0);
//         }
//     }
//     return mp.containsValue(1) ?count+1:count;
// }
// }