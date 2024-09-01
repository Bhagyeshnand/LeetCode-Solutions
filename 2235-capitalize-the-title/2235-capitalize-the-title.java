class Solution {
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        int diff = 'a'-'A';
        int length = 0;
        char[] arr = title.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==' '){
                if(length>2){
                    arr[i-length] -= diff;
                }
                length = 0;
            }
            else{
                length++;
            }
        }
        if(length>2){
            arr[arr.length-length] -= diff;
        }
        return new String(arr);
    }
}

// class Solution {
//     public String capitalizeTitle(String title) {
//         String[] arr = title.split(" ");
//         String ans = "";
        
//         for (String s : arr) {
//             int n = s.length();
//             if (n == 1 || n == 2) {
//                 ans += s.toLowerCase() + " ";
//             } else {
//                 s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
//                 ans += s + " ";
//             }
//         }
        
//         return ans.trim();
//     }
// }
