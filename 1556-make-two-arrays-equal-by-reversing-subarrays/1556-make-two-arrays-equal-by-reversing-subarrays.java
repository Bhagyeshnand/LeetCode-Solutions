class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;
        int n = target.length;
        int freq[] = new int[1001];

        for(int i = 0; i<n ; i++){
            ++freq[target[i]];
            --freq[arr[i]];
        }

        for(int num : freq) if(num != 0) return false;
        return true;
    }
}