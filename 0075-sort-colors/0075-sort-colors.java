class Solution {
    public void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1, temp = 0;

        while(mid <= high){
            if(arr[mid] == 0){  // swapping arr[low] and arr[mid] 
                temp = arr[mid]; arr[mid] = arr[low]; arr[low] = temp; 
                ++low; ++mid;
            }
            else if(arr[mid] == 1){
                ++mid;
            }
            else{ // swapping arr[mid] and arr[high]
                temp = arr[mid]; arr[mid] = arr[high]; arr[high] = temp;//Swap
                --high;
            }
        }
    }
}/*
This problem is a variation of the popular Dutch National flag algorithm. 

This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

arr[0….low-1] contains 0. [Extreme left part]
arr[low….mid-1] contains 1.
arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
The middle part i.e. arr[mid….high] is the unsorted segment.
*/