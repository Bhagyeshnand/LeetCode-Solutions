class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int i=25;
        int count = 0;
        int start = 1;
        int ans =0;
        while( i >= 0 && arr[i] != 0){
            ans+=(start * arr[i]);
            count++;
            if(count == 8){ 
                start++;
                count = 0;
            }
            i--;
        }
        return ans;
    }
}