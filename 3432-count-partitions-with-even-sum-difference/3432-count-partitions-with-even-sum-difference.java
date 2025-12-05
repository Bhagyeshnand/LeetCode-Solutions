class Solution {
    public int countPartitions(int[] A) {
        int total = Arrays.stream(A).sum();
        return (total & 1) == 0 ? A.length - 1 : 0;
    }
}