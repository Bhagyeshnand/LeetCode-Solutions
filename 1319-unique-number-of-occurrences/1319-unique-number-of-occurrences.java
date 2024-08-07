class Solution {
    public boolean uniqueOccurrences(int[] ar) {
        int arr[] = new int[2003];
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
       for(int n : ar){
        arr[n + 1000]++;
        set1.add(n);
       }

       for(int n : arr){
        if(n != 0) set.add(n);
       }
       
    return set1.size() == set.size() ? true : false;
    }
}