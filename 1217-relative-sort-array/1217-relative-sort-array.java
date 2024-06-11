class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 1000;
        for( int n : arr1) max = Math.max(max, n);

        int freq[] = new int[max+1];
        for(int n : arr1) freq[n]++;

        int i = 0,j = 0;

        for(i = 0; i< arr2.length; i++){
            while(freq[arr2[i]] > 0){
                arr1[j++] = arr2[i];
                freq[arr2[i]]--;
            }
        }
    
        for(int k = 0; k< freq.length; k++){
            while(freq[k] > 0){
                arr1[j++] = k;
                freq[k]--;
            }
        }
        return arr1;
        
    }
}