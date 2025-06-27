class Solution {
    public int minDeletions(String s) {
        int[] arr=new int[26];
        int result=0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<26;i++){
            while(set.contains(arr[i]) && arr[i]!=0){
                arr[i]--;
                result++;
            }
            set.add(arr[i]);
        }
        return result;
    }
}